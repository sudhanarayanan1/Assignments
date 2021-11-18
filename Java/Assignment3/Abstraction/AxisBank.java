public class AxisBank extends Bank{

    // Abstract methods from Base class Bank implemented here
    @Override
    public void displayBankAddress() {
        System.out.println("Axis Bank, MG Road, Kolkata");
    }

    @Override
    public void displayBankPhone() {
        System.out.println("Axis Bank phone number: 9876364634");
    }

    @Override
    public void displayDenominations() {
        System.out.println("Axis Bank denominations available: 10, 500, 2000");
    }
}
