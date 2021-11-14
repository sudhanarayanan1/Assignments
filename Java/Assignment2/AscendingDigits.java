import java.util.Scanner;

public class AscendingDigits {

    public static void orderDigitsAscending(int num) {

        // 1. Convert number to String to find length of number
        String str = Integer.toString(num);
        int length = str.length();

        // 2. Store individual digits in int array
        int[] numberArray = new int[length];
        for(int i=0; i<length; i++)
        {
            numberArray[i] = num%10;
            num = num / 10;
        }

        // 3. Sort array
        numberArray = sortArray(numberArray);

        // 4. Print array
        for (int i=0; i<length; i++)
        {
            System.out.print(numberArray[i]);
        }
    }

    // Bubble sort the elements of the array
    public static int[] sortArray(int[] numberArray) {
            boolean swapped = true;
            int j = 0;
            int tmp;
            while (swapped) {
                swapped = false;
                j++;
                for (int i = 0; i < numberArray.length - j; i++) {
                    if (numberArray[i] > numberArray[i + 1]) {
                        tmp = numberArray[i];
                        numberArray[i] = numberArray[i + 1];
                        numberArray[i + 1] = tmp;
                        swapped = true;
                    }
                }
            }
            return numberArray;
    }

    public static void main(String[] args) {
        int number;
        System.out.println("Enter the number:");

        // Take number input from the user
        Scanner s = new Scanner(System.in);
        number = s.nextInt();

        orderDigitsAscending(number);
    }
}
