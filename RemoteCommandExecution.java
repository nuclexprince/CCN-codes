import java.io.*;
import java.util.Scanner;

public class RemoteCommandExecution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Get command from user
            System.out.print("Enter command to execute: ");
            String command = sc.nextLine();

            // Execute command
            Process p =
                    Runtime.getRuntime().exec("cmd /c " + command);

            // Read command output
            BufferedReader br =
                    new BufferedReader(
                            new InputStreamReader(
                                    p.getInputStream()));

            String line;

            System.out.println("\n========== COMMAND OUTPUT ==========");

            // Print output
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        sc.close();
    }
}

/*
Sample Output:

Enter command to execute: ipconfig

========== COMMAND OUTPUT ==========

Windows IP Configuration

Ethernet adapter Ethernet:

Connection-specific DNS Suffix  . :
IPv4 Address. . . . . . . . . . : 192.168.1.5
Subnet Mask . . . . . . . . . . : 255.255.255.0
Default Gateway . . . . . . . . : 192.168.1.1
*/