import java.util.Scanner;

public class LowerUpperCase {

    // Method to check if a char is Lower case or Upper
    public String lowerOrUpper(char a)
    {
        if (Character.isLowerCase(a))
        {
            return "Lower Case";
        }
        return "Upper Case";
    }

    public static void main(String[] args) {
        // Take char input from user
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the character: ");
        char c = s.next().charAt(0);

        // If input is not a valid alphabet, return
        if (!Character.isLetter(c))
        {
            System.out.println("Entered value is not an alphabet");
            return;
        }

        // Call method to check if Lower case or Upper
        LowerUpperCase obj = new LowerUpperCase();
        System.out.println("The case is: " + obj.lowerOrUpper(c));
    }
}
