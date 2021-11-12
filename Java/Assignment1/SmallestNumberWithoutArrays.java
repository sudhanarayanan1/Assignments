import java.util.Scanner;

public class SmallestNumberWithoutArrays {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter 4 numbers: ");

        // Set the first input number to smallest
        int smallest = s.nextInt();

        for(int i=0; i<3; i++) {
            int input = s.nextInt();
            // If the newly input number is less than the current
            // smallest, then set the current number as smallest
            if (input < smallest) {
                smallest = input;
            }
        }

        System.out.println("The smallest number is: " + smallest);
    }
}