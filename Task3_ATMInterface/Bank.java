import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, Account> accounts = new HashMap<>();

    public Bank() {
        Account a1 = new Account("user1", "1234", "Santhoshpriyan T N", 50000.00);
        Account a2 = new Account("user2", "5678", "Priya Sharma",        30000.00);
        Account a3 = new Account("user3", "9999", "Arjun Kumar",         75000.00);

        a1.credit(50000, "Account opening");
        a2.credit(30000, "Account opening");
        a3.credit(75000, "Account opening");

        accounts.put(a1.getUserId(), a1);
        accounts.put(a2.getUserId(), a2);
        accounts.put(a3.getUserId(), a3);
    }

    public Account login(String userId, String pin) {
        Account acc = accounts.get(userId);
        return (acc != null && acc.validatePin(pin)) ? acc : null;
    }

    public String[] withdraw(Account acc, double amount) {
        if (amount > 20000)
            return new String[]{"FAIL", "Withdrawal limit is ₹20,000 per transaction."};
        if (!acc.debit(amount, "ATM Withdrawal"))
            return new String[]{"FAIL", String.format("Insufficient funds. Balance: ₹%.2f", acc.getBalance())};
        return new String[]{"OK", String.format("₹%.2f withdrawn. New Balance: ₹%.2f", amount, acc.getBalance())};
    }

    public String[] deposit(Account acc, double amount) {
        if (amount > 100000)
            return new String[]{"FAIL", "Deposit limit is ₹1,00,000 per transaction."};
        acc.credit(amount, "ATM Deposit");
        return new String[]{"OK", String.format("₹%.2f deposited. New Balance: ₹%.2f", amount, acc.getBalance())};
    }

    public String[] transfer(Account from, String toUserId, double amount) {
        if (from.getUserId().equals(toUserId))
            return new String[]{"FAIL", "Cannot transfer to your own account."};
        Account to = accounts.get(toUserId);
        if (to == null)
            return new String[]{"FAIL", "Recipient account not found: " + toUserId};
        if (!from.debit(amount, "Transfer → " + to.getName()))
            return new String[]{"FAIL", String.format("Insufficient funds. Balance: ₹%.2f", from.getBalance())};
        to.credit(amount, "Transfer ← " + from.getName());
        return new String[]{"OK", String.format("₹%.2f sent to %s. Your balance: ₹%.2f",
                amount, to.getName(), from.getBalance())};
    }
}