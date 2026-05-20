import java.util.Scanner;

public class HammingCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get data bits from user
        System.out.print("Enter the number of data bits: ");
        int m = sc.nextInt();

        int[] data = new int[m];

        // Input data bits
        System.out.println("Enter the data bits (0 or 1):");
        for (int i = 0; i < m; i++) {
            data[i] = sc.nextInt();
        }

        // Calculate number of parity bits
        int r = 0;
        while (Math.pow(2, r) < (m + r + 1)) {
            r++;
        }

        int totalBits = m + r;
        int[] hammingCode = new int[totalBits + 1];

        // Place data bits and parity positions
        int j = 0;
        for (int i = 1; i <= totalBits; i++) {
            if ((i & (i - 1)) == 0) {
                hammingCode[i] = 0; // parity bit
            } else {
                hammingCode[i] = data[j++];
            }
        }

        // Calculate parity bits
        for (int i = 0; i < r; i++) {
            int position = (int) Math.pow(2, i);
            int parity = 0;

            for (int k = 1; k <= totalBits; k++) {
                if ((k & position) != 0) {
                    parity ^= hammingCode[k];
                }
            }

            hammingCode[position] = parity;
        }

        // Display Hamming code
        System.out.println("\n========== HAMMING CODE ==========");
        System.out.print("Generated Hamming Code: ");

        for (int i = totalBits; i >= 1; i--) {
            System.out.print(hammingCode[i] + " ");
        }

        sc.close();
    }
}

/*
Sample Output:

Enter the number of data bits: 4
Enter the data bits (0 or 1):
1 0 1 1

========== HAMMING CODE ==========
Generated Hamming Code: 1 0 1 0 1 0 1
*/