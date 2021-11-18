public abstract class Bank {

    // Abstract methods to be implemented in the sub classes
    public abstract void displayBankAddress();
    public abstract void displayBankPhone();
    public abstract void displayDenominations();

    public static void main(String[] args) {
        Bank axis = new AxisBank();
        axis.displayBankAddress();
        axis.displayBankPhone();
        axis.displayDenominations();

        Bank hdfc = new HDFCBank();
        hdfc.displayBankAddress();
        hdfc.displayBankPhone();
        hdfc.displayDenominations();

        Bank icici = new ICICIBank();
        icici.displayBankAddress();
        icici.displayBankPhone();
        icici.displayDenominations();
    }
}
