import java.util.Scanner;

public class LinkStateRouting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get number of nodes
        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();

        int[][] cost = new int[n][n];
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        // Get cost matrix from user
        System.out.println("Enter the cost matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();

                // Replace 0 with large value except diagonal
                if (i != j && cost[i][j] == 0) {
                    cost[i][j] = 999;
                }
            }
        }

        // Get source node
        System.out.print("Enter the source node (0 to " + (n - 1) + "): ");
        int source = sc.nextInt();

        // Initialize distances
        for (int i = 0; i < n; i++) {
            distance[i] = cost[source][i];
            visited[i] = false;
        }

        visited[source] = true;
        distance[source] = 0;

        // Dijkstra’s Algorithm
        for (int count = 0; count < n - 1; count++) {
            int min = 999, nextNode = -1;

            // Find nearest unvisited node
            for (int i = 0; i < n; i++) {
                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    nextNode = i;
                }
            }

            // Mark node as visited
            visited[nextNode] = true;

            // Update shortest distance
            for (int i = 0; i < n; i++) {
                if (!visited[i] &&
                        (min + cost[nextNode][i] < distance[i])) {
                    distance[i] = min + cost[nextNode][i];
                }
            }
        }

        // Display routing table
        System.out.println("\n========== LINK STATE ROUTING ==========");
        System.out.println("Source Node: " + source);
        System.out.println("\nShortest Path Cost to Other Nodes:");

        for (int i = 0; i < n; i++) {
            System.out.println("Node " + source + " -> Node " + i +
                    " = " + distance[i]);
        }

        sc.close();
    }
}

/*
Sample Output:

Enter the number of nodes: 4
Enter the cost matrix:
0 2 5 0
2 0 3 4
5 3 0 1
0 4 1 0
Enter the source node (0 to 3): 0

========== LINK STATE ROUTING ==========
Source Node: 0

Shortest Path Cost to Other Nodes:
Node 0 -> Node 0 = 0
Node 0 -> Node 1 = 2
Node 0 -> Node 2 = 5
Node 0 -> Node 3 = 6
*/