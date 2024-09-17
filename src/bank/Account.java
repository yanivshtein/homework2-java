package bank;

public class Account {
    private String name;  // Account holder's name
    private int amount;  // Amount of shekels in the account

    // Constructor to initialize the account with the account holder's name and set the initial amount to 0
    public Account(String name) {
        this.name = name;
        this.amount = 0;
    }

    // Method to get the amount of shekels in the account
    public int getShekels() {
        return amount;
    }

    // Method to get the name of the account holder
    public String getName() {
        return name;
    }

    // Method to add (or decrease) a specified amount of shekels to the account
    public void add(int amount) {
        this.amount += amount;
    }

    //toString method
    public String toString() {
        return name + " has " + amount + " shekels";
    }
}
