import java.util.Scanner;

public class ShortestPathRouting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get number of nodes
        System.out.print("Enter the number of nodes in the network: ");
        int n = sc.nextInt();

        int[][] cost = new int[n][n];
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        // Get cost matrix
        System.out.println("Enter the cost matrix:");
        System.out.println("(Enter 0 if there is no direct connection)");

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

        // Initialize distance and visited arrays
        for (int i = 0; i < n; i++) {
            distance[i] = cost[source][i];
            visited[i] = false;
        }

        visited[source] = true;
        distance[source] = 0;

        // Apply Dijkstra's Algorithm
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

            // Update shortest distances
            for (int i = 0; i < n; i++) {
                if (!visited[i] &&
                    (min + cost[nextNode][i] < distance[i])) {
                    distance[i] = min + cost[nextNode][i];
                }
            }
        }

        // Display shortest path details
        System.out.println("\n========== SHORTEST PATH ROUTING ==========");
        System.out.println("Source Node: " + source);

        System.out.println("\nMinimum Cost to Reach Other Nodes:");
        for (int i = 0; i < n; i++) {
            System.out.println("From Node " + source +
                    " to Node " + i +
                    " --> Cost = " + distance[i]);
        }

        System.out.println("\nShortest path calculation completed successfully.");

        sc.close();
    }
}

/*
Sample Output:

Enter the number of nodes in the network: 4
Enter the cost matrix:
(Enter 0 if there is no direct connection)
0 2 5 0
2 0 3 4
5 3 0 1
0 4 1 0
Enter the source node (0 to 3): 0

========== SHORTEST PATH ROUTING ==========
Source Node: 0

Minimum Cost to Reach Other Nodes:
From Node 0 to Node 0 --> Cost = 0
From Node 0 to Node 1 --> Cost = 2
From Node 0 to Node 2 --> Cost = 5
From Node 0 to Node 3 --> Cost = 6

Shortest path calculation completed successfully.
*/