import java.util.Scanner;
import java.io.*;

public class EchoPing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Get status note from engineer
            System.out.print("Enter server status note: ");
            String note = sc.nextLine();

            // Echo the status note
            Process p1 =
                    Runtime.getRuntime().exec("cmd /c echo " + note);

            BufferedReader br1 =
                    new BufferedReader(
                            new InputStreamReader(
                                    p1.getInputStream()));

            System.out.println("\n========== STATUS NOTE ==========");
            System.out.println("Echoed Note: " + br1.readLine());

            // Get server IP address
            System.out.print("\nEnter Server IP Address: ");
            String ip = sc.nextLine();

            // Ping the server
            Process p2 =
                    Runtime.getRuntime().exec("cmd /c ping " + ip);

            BufferedReader br2 =
                    new BufferedReader(
                            new InputStreamReader(
                                    p2.getInputStream()));

            String line;
            boolean reachable = false;

            // Check ping response
            while ((line = br2.readLine()) != null) {
                if (line.contains("Reply from")) {
                    reachable = true;
                }
            }

            // Display server status
            System.out.println("\n========== SERVER STATUS ==========");

            if (reachable) {
                System.out.println("Server is Reachable.");
            } else {
                System.out.println("Server is NOT Reachable.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        sc.close();
    }
}

/*
Sample Output:

Enter server status note: Server may be down

========== STATUS NOTE ==========
Echoed Note: Server may be down

Enter Server IP Address: 8.8.8.8

========== SERVER STATUS ==========
Server is Reachable.
*/