import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String args[]) throws Exception {

        // Create server socket
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server waiting...");

        // Accept client connection
        Socket s = ss.accept();
        System.out.println("Client connected.");

        // Receive data from client
        DataInputStream dis =
                new DataInputStream(s.getInputStream());

        // Read messages continuously
        while (true) {
            String msg = dis.readUTF();
            System.out.println("Client: " + msg);

            // Stop if client sends exit
            if (msg.equalsIgnoreCase("exit")) {
                break;
            }
        }

        // Close connection
        s.close();
        ss.close();
    }
}

/*
Sample Output (Server):

Server waiting...
Client connected.

Client: Hello Server
Client: How are you?
Client: Network Lab Program
Client: exit
*/