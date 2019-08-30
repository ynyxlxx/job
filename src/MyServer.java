import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) throws IOException{
        try{
            ServerSocket serverSocket = new ServerSocket(8686);

            System.out.println("Waiting for the client to connect......");
            Socket client = serverSocket.accept(); // set on listen.
            OutputStream out = client.getOutputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataInputStream dataIn = new DataInputStream(client.getInputStream());
            DataOutputStream dataOut = new DataOutputStream(out);
            String inputMsg = "";
            String outputMsg = "";
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("A client has connected.");
            try {
                while (true) {
                    inputMsg = dataIn.readUTF();
                    System.out.println("server received -> " + inputMsg);
                    dataOut.writeUTF(inputMsg.toUpperCase());
                    dataOut.flush();

                    outputMsg = console.readLine();
                    System.out.println("server send -> " + outputMsg);
                    dataOut.writeUTF(outputMsg.toLowerCase());
                    dataOut.flush();
                }
            }catch (Exception e) {
                System.out.println("A client has disconnected.");
            }

        }catch (Exception e){
        }
    }


}
