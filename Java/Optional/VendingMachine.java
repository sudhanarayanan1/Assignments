import java.util.InputMismatchException;
import java.util.Scanner;

public class VendingMachine {
    static String[][] itemArray;
    static int vendingMachineBalance = 0;

    public  static void setupVendingMachine() {
        itemArray = new String[][]{
                {"001", "Chips", "40"},
                {"002", "Biscuit", "30"},
                {"003", "Chocolate", "20"},
                {"004", "Cold Drink", "60"}
        };
    }

    // Print formatted Vending machine menu
    public static void printVendingMachineMenu() {
        System.out.printf("%-22s%-22s%-22s\n","Item ID","Item Name","Price");
        System.out.printf("%-22s%-22s%-22s\n",itemArray[0][0], itemArray[0][1], itemArray[0][2]);
        System.out.printf("%-22s%-22s%-22s\n",itemArray[1][0],itemArray[1][1],itemArray[1][2]);
        System.out.printf("%-22s%-22s%-22s\n",itemArray[2][0],itemArray[2][1],itemArray[2][2]);
        System.out.printf("%-22s%-22s%-22s\n",itemArray[3][0],itemArray[3][1],itemArray[3][2]);
    }

    // Dispense item, Return change, Update Vending machine balance
    public static void dispenseAndReturnChange(int id, int amount) {
        int itemPrice = Integer.parseInt(itemArray[id-1][2]);
        if (itemPrice <= amount)
        {
            System.out.println("Dispensing " + itemArray[id-1][1]);
            System.out.println("Returning change of Rs " + (amount - itemPrice));
            vendingMachineBalance = vendingMachineBalance + Integer.parseInt(itemArray[id-1][2]);
            return;
        }
        System.out.println("Insufficient amount. Try again.");
    }

    public static void main(String[] args) {
        char reply = 'n';
        Scanner s = new Scanner(System.in);
        setupVendingMachine();

        do {
            printVendingMachineMenu();
            // Take user input for item id and amount
            try {
                System.out.println("Enter Item ID: ");
                int id = s.nextInt();
                System.out.println("Enter amount: ");
                int amount = s.nextInt();
                dispenseAndReturnChange(id, amount);
            } catch (InputMismatchException e) {
                System.out.println("Entered input is not a number");
            }
            System.out.println("Do you want to continue (y/n)?: ");
            reply = s.next().charAt(0);
        } while (reply == 'Y' || reply == 'y');
    }
}
