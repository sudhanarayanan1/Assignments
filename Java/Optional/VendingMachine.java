import jdk.swing.interop.SwingInterOpUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class VendingMachine {
    static String[][] itemArray;
    static ArrayList<String> transactionList;
    static int vendingMachineBalance = 0;

    // Print Main menu options
    public static void printOptions()
    {
        System.out.println("Enter the option: ");
        System.out.println("1. Buy item" );
        System.out.println("2. View Vending Machine balance");
        System.out.println("3. View all previous transactions");
    }

    // Initialize product details of VM
    public  static void setupVendingMachine() {
        transactionList = new ArrayList<>();
        itemArray = new String[][]{
                {"001", "Chips", "40"},
                {"002", "Biscuit", "30"},
                {"003", "Chocolate", "20"},
                {"004", "Cold Drink", "60"}
        };
    }

    // Print formatted Vending machine item menu
    public static void printVendingMachineMenu() {
        System.out.printf("%-22s%-22s%-22s\n","Item ID","Item Name","Price");
        System.out.printf("%-22s%-22s%-22s\n",itemArray[0][0], itemArray[0][1], itemArray[0][2]);
        System.out.printf("%-22s%-22s%-22s\n",itemArray[1][0],itemArray[1][1],itemArray[1][2]);
        System.out.printf("%-22s%-22s%-22s\n",itemArray[2][0],itemArray[2][1],itemArray[2][2]);
        System.out.printf("%-22s%-22s%-22s\n",itemArray[3][0],itemArray[3][1],itemArray[3][2]);
    }

    // Dispense item, Return change, Update Vending machine balance
    public static void dispenseAndReturnChange(int id, int amount) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String transaction = null;
        int itemPrice = Integer.parseInt(itemArray[id-1][2]);
        if (itemPrice <= amount)
        {
            System.out.println("Dispensing " + itemArray[id-1][1]);
            System.out.println("Returning change of Rs " + (amount - itemPrice));
            vendingMachineBalance = vendingMachineBalance + Integer.parseInt(itemArray[id-1][2]);
            transaction = timeStamp + Integer.toString(id) + "   \t" + Integer.toString(id) + "\t\t\t" + Integer.toString(amount) + "\t\t" + Integer.toString(amount-itemPrice) + "\t\t" + Integer.toString(vendingMachineBalance);
            transactionList.add(transaction);
            return;
        }
        System.out.println("Insufficient amount. Try again.");
    }

    // Printing all vending machine transactions
    private static void printTransactions() {
        System.out.println("Date&Time" + "\t\t\t\t" + "Item" + "\t" + "Amount" + "\t" + "Refund" + "\t" + "Vending Machine balance");
        for (int i=0; i<transactionList.size(); i++) {
            String transaction = transactionList.get(i);
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) {
        char reply = 'n';
        int option;
        Scanner s = new Scanner(System.in);
        setupVendingMachine();

        do {
            printOptions();
            option = s.nextInt();

            switch (option) {
                case 1:
                    printVendingMachineMenu();
                    // Take user input for item id and amount
                    try {
                        System.out.println("Enter Item ID: ");
                        int id = s.nextInt();
                        if (id < 1 || id > 4) {
                            throw new InputMismatchException();
                        }
                        System.out.println("Enter amount: ");
                        int amount = s.nextInt();
                        dispenseAndReturnChange(id, amount);
                        } catch (InputMismatchException e) {
                            System.out.println("Entered input is invalid");
                        }
                        break;
                case 2:
                        System.out.println("Vending machine balance is: Rs " + vendingMachineBalance);
                        break;
                case 3:
                        printTransactions();
                        break;
                default:
                        System.out.println("Invalid option");
                        break;
                }

            System.out.println("Do you want to continue (y/n)?: ");
            reply = s.next().charAt(0);
        } while (reply == 'Y' || reply == 'y');
    }
}
