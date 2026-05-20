import java.util.Scanner;

public class CRC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get data bits
        System.out.print("Enter the data bits: ");
        String data = sc.next();

        // Get divisor (generator polynomial)
        System.out.print("Enter the divisor bits: ");
        String divisor = sc.next();

        int dataLength = data.length();
        int divisorLength = divisor.length();

        // Append zeros to data
        String appendedData = data;
        for (int i = 0; i < divisorLength - 1; i++) {
            appendedData += "0";
        }

        char[] dividend = appendedData.toCharArray();
        char[] divisorArray = divisor.toCharArray();

        // Perform XOR division
        for (int i = 0; i <= dataLength - 1; i++) {

            if (dividend[i] == '1') {

                for (int j = 0; j < divisorLength; j++) {

                    // XOR operation
                    dividend[i + j] =
                            (dividend[i + j] == divisorArray[j]) ? '0' : '1';
                }
            }
        }

        // Get CRC remainder
        String remainder = "";
        for (int i = dataLength; i < dividend.length; i++) {
            remainder += dividend[i];
        }

        // Generate transmitted data
        String transmittedData = data + remainder;

        // Display result
        System.out.println("\n========== CYCLIC REDUNDANCY CHECK ==========");
        System.out.println("Original Data       : " + data);
        System.out.println("Divisor             : " + divisor);
        System.out.println("CRC Remainder       : " + remainder);
        System.out.println("Transmitted Data    : " + transmittedData);

        System.out.println("\nData transmitted successfully.");

        sc.close();
    }
}

/*
Sample Output:

Enter the data bits: 110101
Enter the divisor bits: 1011

========== CYCLIC REDUNDANCY CHECK ==========
Original Data       : 110101
Divisor             : 1011
CRC Remainder       : 111
Transmitted Data    : 110101111

Data transmitted successfully.
*/