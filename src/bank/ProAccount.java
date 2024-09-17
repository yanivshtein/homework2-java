package bank;

public class ProAccount extends Account {
    private int[] history = new int[100];  // Array to keep track of transaction history
    private int transactions = 0;  // Counter for the number of transactions

    // Constructor to initialize the ProAccount with the account holder's name
    public ProAccount(String name) {
        super(name);
    }

    // Override the add method to add a specified amount of shekels to the account and record the transaction history
    @Override
    public void add(int amount) {
        super.add(amount);  // Call the superclass add method
        history[transactions] = getShekels();  // Record the account balance after the transaction
        transactions++;
    }

    //toString method to print the info how i want it
    public String toString() {
        StringBuilder str = new StringBuilder(super.toString() + " [");
        for (int i = 0; i < transactions; i++) {
            str.append(history[i]);
            if (i != transactions - 1) {
                str.append(",");
            }
        }
        str.append("]");
        return str.toString();
    }

    // Static method to transfer a specified amount of shekels from one ProAccount to another
    public static void transfer(ProAccount from, ProAccount to, int amount) {
        from.add(-amount);  // Subtract the amount from the sender's account
        to.add(amount);  // Add the amount to the receiver's account
    }
}
