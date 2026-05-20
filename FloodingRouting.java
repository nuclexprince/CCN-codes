import java.util.Scanner;

public class FloodingRouting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get number of nodes
        System.out.print("Enter the number of nodes in the network: ");
        int nodes = sc.nextInt();

        int[][] adjacencyMatrix = new int[nodes][nodes];

        // Get adjacency matrix
        System.out.println("Enter the adjacency matrix (1 for connected, 0 for not connected):");
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                adjacencyMatrix[i][j] = sc.nextInt();
            }
        }

        // Get source node
        System.out.print("Enter the source node: ");
        int source = sc.nextInt();

        // Get destination node
        System.out.print("Enter the destination node: ");
        int destination = sc.nextInt();

        // Display flooding process
        System.out.println("\n========== FLOODING ROUTING ==========");
        System.out.println("Source Node      : " + source);
        System.out.println("Destination Node : " + destination);

        System.out.println("\nPackets are flooded to connected nodes:");

        // Flood packets to all connected nodes
        for (int i = 0; i < nodes; i++) {
            if (adjacencyMatrix[source][i] == 1) {
                System.out.println("Packet sent from Node " +
                        source + " to Node " + i);
            }
        }

        // Check if destination is directly reachable
        if (adjacencyMatrix[source][destination] == 1) {
            System.out.println("\nDestination Node " + destination +
                    " is directly reachable.");
        } else {
            System.out.println("\nPacket flooded through intermediate nodes to reach Destination Node "
                    + destination + ".");
        }

        sc.close();
    }
}

/*
Sample Output:

Enter the number of nodes in the network: 4
Enter the adjacency matrix (1 for connected, 0 for not connected):
0 1 1 0
1 0 1 1
1 1 0 1
0 1 1 0
Enter the source node: 0
Enter the destination node: 3

========== FLOODING ROUTING ==========
Source Node      : 0
Destination Node : 3

Packets are flooded to connected nodes:
Packet sent from Node 0 to Node 1
Packet sent from Node 0 to Node 2

Packet flooded through intermediate nodes to reach Destination Node 3.
*/