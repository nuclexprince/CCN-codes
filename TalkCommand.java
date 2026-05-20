import java.util.Scanner;

public class TalkCommand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get user messages
        System.out.print("Enter your message: ");
        String message = sc.nextLine();

        System.out.println("\n========== TALK COMMAND ==========");
        System.out.println("User: " + message);

        // Simulated reply
        System.out.println("Receiver: Message received successfully.");

        sc.close();
    }
}

/*
Sample Output:

Enter your message: Hello, how are you?

========== TALK COMMAND ==========
User: Hello, how are you?
Receiver: Message received successfully.
*/