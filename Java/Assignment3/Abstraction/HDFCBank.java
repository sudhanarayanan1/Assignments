public class HDFCBank extends Bank{

    // Abstract methods from Base class Bank implemented here
    @Override
    public void displayBankAddress() {
        System.out.println("HDFC Bank, Mulund, Mumbai");
    }

    @Override
    public void displayBankPhone() {
        System.out.println("HDFC Bank phone number: 983737434");
    }

    @Override
    public void displayDenominations() {
        System.out.println("HDFC Bank avaiable denominations: Rs 100, 500, 1000");
    }
}
