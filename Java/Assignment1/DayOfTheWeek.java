import java.sql.SQLOutput;
import java.util.Scanner;

/*
    Class to find out the day of the week, when a day of the month is input
*/
public class DayOfTheWeek {

    public static void main(String[] args) {

        int number = 0;
        String day = "";

        // Take input of day of the month from the user
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the day of the month:");
        number = s.nextInt();

        // Check for invalid input
        if (number < 1 || number > 30) {
            System.out.println("Invalid input");
            return;
        }

        switch (number % 7)
        {
            case 0:
                day = "Sunday";
                break;
            case 1:
                day = "Monday";
                break;
            case 2:
                day = "Tuesday";
                break;
            case 3:
                day = "Wednesday";
                break;
            case 4:
                day = "Thursday";
                break;
            case 5:
                day = "Friday";
                break;
            case 6:
                day = "Saturday";
                break;
            default:
                day = "unknown";
                break;
        }

        System.out.println("The day of the week is: " + day);
    }
}
