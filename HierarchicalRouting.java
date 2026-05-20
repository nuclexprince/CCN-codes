import java.util.Scanner;

public class HierarchicalRouting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get number of regions
        System.out.print("Enter the number of regions in the network: ");
        int regions = sc.nextInt();

        int[] routers = new int[regions];

        // Get number of routers in each region
        for (int i = 0; i < regions; i++) {
            System.out.print("Enter number of routers in Region " + (i + 1) + ": ");
            routers[i] = sc.nextInt();
        }

        // Display routing information
        System.out.println("\n========== HIERARCHICAL ROUTING ==========");

        for (int i = 0; i < regions; i++) {
            System.out.println("\nRegion " + (i + 1) + " Details:");
            System.out.println("Number of Routers: " + routers[i]);

            // Display routers in each region
            System.out.println("Routers Available:");
            for (int j = 1; j <= routers[i]; j++) {
                System.out.println("   -> Router " + j);
            }
        }

        System.out.println("\nRouting hierarchy created successfully.");

        sc.close();
    }
}

/*Enter the number of regions in the network: 2
Enter number of routers in Region 1: 3
Enter number of routers in Region 2: 2

========== HIERARCHICAL ROUTING ==========

Region 1 Details:
Number of Routers: 3
Routers Available:
   -> Router 1
   -> Router 2
   -> Router 3

Region 2 Details:
Number of Routers: 2
Routers Available:
   -> Router 1
   -> Router 2

Routing hierarchy created successfully.*/