public class ICICIBank extends Bank{

    // Abstract methods from Base class Bank implemented here
    @Override
    public void displayBankAddress() {
        System.out.println("ICICI Bank address: Anna Salai, Chennai");
    }

    @Override
    public void displayBankPhone() {
        System.out.println("ICICI Bank phone number: 8984757577");
    }

    @Override
    public void displayDenominations() {
        System.out.println("ICICI Bank denominations available: Rs 500");
    }
}
