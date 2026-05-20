import java.util.Scanner;

public class SlidingWindowProtocol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get total number of frames
        System.out.print("Enter total number of frames: ");
        int totalFrames = sc.nextInt();

        // Get window size
        System.out.print("Enter window size: ");
        int windowSize = sc.nextInt();

        System.out.println("\n========== SLIDING WINDOW PROTOCOL ==========");

        // Send frames using sliding window
        for (int i = 1; i <= totalFrames; i += windowSize) {

            System.out.println("\nSending Frames:");

            // Send frames within the window
            for (int j = i; j < i + windowSize && j <= totalFrames; j++) {
                System.out.println("Frame " + j + " sent");
            }

            // Acknowledgement
            System.out.println("Acknowledgement received.");
        }

        System.out.println("\nAll frames transmitted successfully.");

        sc.close();
    }
}

/*
Sample Output:

Enter total number of frames: 8
Enter window size: 3

========== SLIDING WINDOW PROTOCOL ==========

Sending Frames:
Frame 1 sent
Frame 2 sent
Frame 3 sent
Acknowledgement received.

Sending Frames:
Frame 4 sent
Frame 5 sent
Frame 6 sent
Acknowledgement received.

Sending Frames:
Frame 7 sent
Frame 8 sent
Acknowledgement received.

All frames transmitted successfully.
*/