import java.util.Scanner;

public class Calculator {

    public static void PrintCalculatorOptions() {
        System.out.println("Calculator:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("Enter the operation code: ");
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        int operation, a, b;
        double result = 0.0;
        char reply = 'n';

        Scanner s = new Scanner(System.in);
        do {
            PrintCalculatorOptions();

            // User input for operation to be performed
            operation = s.nextInt();
            if (operation<1 || operation>4)
            {
                System.out.println("Invalid operation code. Try again");
                reply = 'y';
                continue;
            }

            System.out.println("Enter the 2 numbers:");
            a = s.nextInt();
            b = s.nextInt();

            Calculator calc = new Calculator();
            switch (operation) {
                case 1:
                    result = calc.add(a, b);
                    break;
                case 2:
                    result = calc.subtract(a, b);
                    break;
                case 3:
                    result = calc.multiply(a, b);
                    break;
                case 4:
                    result = calc.divide(a, b);
                    break;
            }

            System.out.println("The result is: " + result + "\n");
            System.out.println("Do you want to continue (y/n)?: ");
            reply = s.next().charAt(0);
        } while (reply == 'Y' || reply == 'y');
    }
}
