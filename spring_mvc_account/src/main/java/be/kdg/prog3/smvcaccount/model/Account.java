package be.kdg.prog3.smvcaccount.model;

public class Account {
    private final String owner;
    private double balance;

    public Account(String owner) {
        this.owner = owner;
        this.balance = 0.0;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
