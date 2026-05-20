import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String args[]) throws Exception {

        // Connect to server
        Socket s = new Socket("localhost", 5000);

        // Send data to server
        DataOutputStream dos =
                new DataOutputStream(s.getOutputStream());

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));

        System.out.println("Connected to Server.");
        System.out.println("Type messages (type 'exit' to stop):");

        while (true) {

            // Get user input
            String msg = br.readLine();

            // Send message
            dos.writeUTF(msg);

            // Stop if exit entered
            if (msg.equalsIgnoreCase("exit")) {
                break;
            }
        }

        // Close connection
        s.close();
    }
}

/*
Sample Output (Client):

Connected to Server.
Type messages (type 'exit' to stop):

Hello Server
How are you?
Network Lab Program
exit
*/