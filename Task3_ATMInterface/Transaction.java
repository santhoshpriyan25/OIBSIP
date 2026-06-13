import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final String type;
    private final double amount;
    private final String description;
    private final double balanceAfter;
    private final String timestamp;

    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("dd MMM yyyy  HH:mm:ss");

    public Transaction(String type, double amount, String description, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.balanceAfter = balanceAfter;
        this.timestamp = LocalDateTime.now().format(FMT);
    }

    public String getType()        { return type; }
    public double getAmount()      { return amount; }
    public String getDescription() { return description; }
    public double getBalanceAfter(){ return balanceAfter; }
    public String getTimestamp()   { return timestamp; }
}