//Student name:
//Student ID  :

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Hashtable;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MsgServer extends JFrame
{
    private ServerSocket servSocket;
    private static final int PORT = 12345;
    
    private Hashtable<String, UserRecord> userTable;
    private JTextArea display;
    
    public MsgServer(String filename)
    {	
        userTable = new Hashtable();
        try
        {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNext())
            {
                String name = sc.next().toUpperCase();
                userTable.put(name, new UserRecord(name));
            }
            sc.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");                    
        }
                
        try
        {
            servSocket = new ServerSocket(PORT);
        }                
        catch (IOException e)
        {
            System.out.println("\nUnable to set up port!");
            System.exit(1);
        }        

        setTitle("Message Server");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Messages received:");
        display = new JTextArea(50, 10);
        display.setEditable(false);

        JScrollPane sp = new JScrollPane(display);

        add(label, "North");
        add(sp, "Center");              
        setVisible(true);
    }


    public static void main(String[] args) throws IOException
    {	
        MsgServer ms = new MsgServer("userlist.txt");
        ms.go();
    }

    synchronized protected void displayMsg(String m)
    {
        display.append(m + "\n");       
    }
    
    public void go()
    {	
        System.out.println("Message Server started");

        do
        {
            //Wait for client...
            try
            {
                Socket client = servSocket.accept();

                System.out.println("New client accepted.");

                ClientHandler handler = new ClientHandler(client, this);
                handler.start();

            }
            catch (IOException e)
            { }

        } while (true);
    }

    synchronized protected boolean connectRequest(String user, ClientHandler handler)
    {
        UserRecord r = userTable.get(user.toUpperCase());
        if (r != null)
        {
            if (r.handler != null)
            {
                handler.sendMessage("msg : Multiple connections not supported");
                handler.interrupt();                    
            }
            else
            {
                r.handler = handler;
                r.handler.sendMessage("count : " + r.msgQueue.size());
            }
            return true;
        }
        else
        {
            handler.sendMessage("msg : " + "Invalid user : " + user);
            return false;
        }
    }
        
    synchronized protected void getRequest(String user)
    {
        UserRecord r = userTable.get(user.toUpperCase());
        if (r != null)
            if (r.msgQueue.isEmpty())
                r.handler.sendMessage("msg : No message");
            else
            {
                String m = r.msgQueue.remove();
                r.handler.sendMessage("msg : " + m);
                r.handler.sendMessage("count : " + r.msgQueue.size());
            }
    }
        
    synchronized protected void sendRequest(ClientHandler handler, String sender, String recipient, String msg)
    {
        UserRecord r = userTable.get(recipient.toUpperCase());
        if (r != null)
        {
            r.msgQueue.add(sender + " : " + msg);
            if (r.handler != null)
                r.handler.sendMessage("count : " + r.msgQueue.size());       
        }
        else
        {
            handler.sendMessage("msg : Invalid recipient : " + recipient);
        }
    }        
        
    synchronized protected void quitRequest(String user, ClientHandler handler)
    {
        UserRecord r = userTable.get(user.toUpperCase());
        if (r != null)
        {
            if (r.handler == handler)
                r.handler = null;                    
        }
    }
        
    private class UserRecord 
    {
        String userName;
        ClientHandler handler;
        ArrayDeque<String> msgQueue;
    
        UserRecord(String name)
        {
            userName = name;
            handler = null;
            msgQueue = new ArrayDeque();
        }    
    }
}

class ClientHandler extends Thread
{
    private String user;
    private Socket client;
    private Scanner in;
    private PrintWriter out;
    private MsgServer mServer;

    public ClientHandler(Socket socket, MsgServer ms)
    {
        client = socket;
        mServer = ms;
        try
        {
            in = new Scanner(client.getInputStream());
            out = new PrintWriter(client.getOutputStream(),true);
        }
        catch(IOException e)
        {   }
    }

    public void sendMessage(String m)
    {	
        out.println(m);
    }

    @Override
    public void run()
    {	
        try
        {				
            while (true)
            {
                String received = in.nextLine();
                mServer.displayMsg(received);
                
                if (isInterrupted())
                    break;
                
                String[] tokens = received.split("\\s*:\\s*");
                                
                if (tokens[0].equals("connect"))
                {
                    user = tokens[1];
                    if (!mServer.connectRequest(user, this))
                        break;
                }
                else if(tokens[0].equals("get"))
                {
                    mServer.getRequest(tokens[1]);
                }
                else if (tokens[0].equals("send"))
                {
                    mServer.sendRequest(this, tokens[1], tokens[3], tokens[4]);
                }
                if (tokens[0].equals("quit"))
                {
                    mServer.quitRequest(tokens[1], this);
                    break;
                }
            } 
        }
        catch(IllegalStateException e)
        {  }
        finally
        {
            mServer.quitRequest(user, this);                        
            try
            {
                if (client!=null)
                {	
                    System.out.println("Closing down connection...");
                    client.close();
                }
            }
            catch(IOException e)
            {  }
        }
    }
}

