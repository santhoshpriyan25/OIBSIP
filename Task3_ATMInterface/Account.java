import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String userId;
    private final String pin;
    private final String name;
    private double balance;
    private final List<Transaction> history;

    public Account(String userId, String pin, String name, double initialBalance) {
        this.userId = userId;
        this.pin = pin;
        this.name = name;
        this.balance = initialBalance;
        this.history = new ArrayList<>();
    }

    public boolean validatePin(String inputPin) { return this.pin.equals(inputPin); }
    public String getUserId()  { return userId; }
    public String getName()    { return name; }
    public double getBalance() { return balance; }

    public void credit(double amount, String description) {
        balance += amount;
        history.add(new Transaction("CREDIT", amount, description, balance));
    }

    public boolean debit(double amount, String description) {
        if (amount > balance) return false;
        balance -= amount;
        history.add(new Transaction("DEBIT", amount, description, balance));
        return true;
    }

    public List<Transaction> getHistory() { return history; }
}