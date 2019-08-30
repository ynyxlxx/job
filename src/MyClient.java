import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
    public static void main(String[] args) throws UnknownHostException, IOException{
        Socket client = new Socket("localhost",8686);
        System.out.println("connected to the server.");
        String outputMsg = "";
        String inputMsg = "";

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dataOut = new DataOutputStream(client.getOutputStream());
        DataInputStream dataIn = new DataInputStream(client.getInputStream());

        while (true){
            outputMsg = console.readLine();
            if (outputMsg.equals("break")) {
                System.out.println("disconnected from server.");
                break;
            }
            dataOut.writeUTF(outputMsg);
            dataOut.flush();

            inputMsg = dataIn.readUTF();
            System.out.println("server respones -> " + inputMsg);
        }


    }
}
