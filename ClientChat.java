import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClientChat {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            // Connect to server
            Socket s = new Socket("localhost", 5000);
            System.out.println("Connected to Server!");

            // Input and output streams
            DataInputStream dis =
                    new DataInputStream(s.getInputStream());

            DataOutputStream dos =
                    new DataOutputStream(s.getOutputStream());

            String msg = "";

            // Alternate messaging
            while (!msg.equalsIgnoreCase("exit")) {

                // Send message to server
                System.out.print("Client: ");
                msg = sc.nextLine();
                dos.writeUTF(msg);

                if (msg.equalsIgnoreCase("exit"))
                    break;

                // Receive reply from server
                msg = dis.readUTF();
                System.out.println("Server: " + msg);
            }

            // Close connection
            s.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*
Sample Output (Client):

Connected to Server!

Client: Hello Server
Server: Hello Client

Client: How are you?
Server: I am fine

Client: exit
*/