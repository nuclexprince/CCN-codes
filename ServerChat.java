import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ServerChat {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            // Create server socket
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server is waiting for connection...");

            // Accept client connection
            Socket s = ss.accept();
            System.out.println("Client connected!");

            // Input and output streams
            DataInputStream dis =
                    new DataInputStream(s.getInputStream());

            DataOutputStream dos =
                    new DataOutputStream(s.getOutputStream());

            String msg = "";

            // Alternate messaging
            while (!msg.equalsIgnoreCase("exit")) {

                // Receive message from client
                msg = dis.readUTF();
                System.out.println("Client: " + msg);

                if (msg.equalsIgnoreCase("exit"))
                    break;

                // Send reply from server
                System.out.print("Server: ");
                msg = sc.nextLine();
                dos.writeUTF(msg);
            }

            // Close connection
            s.close();
            ss.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*
Sample Output (Server):

Server is waiting for connection...
Client connected!

Client: Hello Server
Server: Hello Client

Client: How are you?
Server: I am fine

Client: exit
*/