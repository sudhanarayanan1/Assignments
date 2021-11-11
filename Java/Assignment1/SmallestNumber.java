import java.io.File;
import java.util.Scanner;

public class SmallestNumber {
    // Number of inputs taken
    static int INPUTCOUNT = 4;

    // Method to find the smallest number in an array
    public int findSmallestNumber(int[] num)
    {
        int smallest = num[0];

        for (int i=1; i<num.length-1; i++)
        {
            if (num[i] < smallest)
            {
                smallest = num[i];
            }
        }
        return smallest;
    }

    public static void main(String[] args) {

        int[] numbers = new int[INPUTCOUNT];

        // Take input of numbers from user
        Scanner s = new Scanner(System.in);
        System.out.println("Enter " + INPUTCOUNT + "numbers");

        for(int i=0; i<INPUTCOUNT; i++) {
            numbers[i] = s.nextInt();
        }

        SmallestNumber sm = new SmallestNumber();
        System.out.println("Smallest number is: " + sm.findSmallestNumber(numbers));
    }
}
