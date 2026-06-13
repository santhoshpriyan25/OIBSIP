import java.util.List;

public class UI {

    public static final String RESET   = "\033[0m";
    public static final String BOLD    = "\033[1m";
    public static final String DIM     = "\033[2m";
    public static final String RED     = "\033[1;31m";
    public static final String GREEN   = "\033[1;32m";
    public static final String YELLOW  = "\033[1;33m";
    public static final String BLUE    = "\033[1;34m";
    public static final String MAGENTA = "\033[1;35m";
    public static final String CYAN    = "\033[1;36m";
    public static final String WHITE   = "\033[1;37m";

    public void printWelcome() {
        clearScreen();
        System.out.println();
        System.out.println(CYAN  + "  ╔══════════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN  + "  ║" + RESET + BOLD + "            🏦  OIBSIP  BANK  ATM  🏦             " + RESET + CYAN + "║" + RESET);
        System.out.println(CYAN  + "  ║" + RESET + DIM  + "          Secure · Fast · Reliable Banking        " + RESET + CYAN + "║" + RESET);
        System.out.println(CYAN  + "  ╠══════════════════════════════════════════════════╣" + RESET);
        System.out.println(CYAN  + "  ║" + RESET + YELLOW + "  Demo Accounts:                                  " + RESET + CYAN + "║" + RESET);
        System.out.println(CYAN  + "  ║" + RESET + DIM   + "  user1 / 1234  →  Santhoshpriyan T N            " + RESET + CYAN + "║" + RESET);
        System.out.println(CYAN  + "  ║" + RESET + DIM   + "  user2 / 5678  →  Priya Sharma                  " + RESET + CYAN + "║" + RESET);
        System.out.println(CYAN  + "  ║" + RESET + DIM   + "  user3 / 9999  →  Arjun Kumar                   " + RESET + CYAN + "║" + RESET);
        System.out.println(CYAN  + "  ╚══════════════════════════════════════════════════╝" + RESET);
        System.out.println();
        System.out.println(DIM   + "  ─────────────────  Login  ─────────────────" + RESET);
        System.out.println();
    }

    public void printLoginSuccess(String name) {
        System.out.println();
        System.out.println(GREEN + "  ╔══════════════════════════════════════════════════╗" + RESET);
        System.out.printf (GREEN + "  ║   ✔  Welcome back, %-30s║%n" + RESET, name + "!");
        System.out.println(GREEN + "  ╚══════════════════════════════════════════════════╝" + RESET);
    }

    public void printMenu(Account acc) {
        System.out.println();
        System.out.println(BLUE  + "  ╔══════════════════════════════════════════════════╗" + RESET);
        System.out.printf (BLUE  + "  ║" + RESET + BOLD + "  👤 %-20s" + RESET + GREEN + "  Balance: ₹%-11.2f" + RESET + BLUE + "║%n" + RESET,
                acc.getName(), acc.getBalance());
        System.out.println(BLUE  + "  ╠══════════════════════════════════════════════════╣" + RESET);
        System.out.println(BLUE  + "  ║" + RESET + "  " + CYAN + "[1]" + RESET + "  📋  Transaction History                    " + BLUE + "║" + RESET);
        System.out.println(BLUE  + "  ║" + RESET + "  " + CYAN + "[2]" + RESET + "  💸  Withdraw Cash                          " + BLUE + "║" + RESET);
        System.out.println(BLUE  + "  ║" + RESET + "  " + CYAN + "[3]" + RESET + "  💰  Deposit Cash                           " + BLUE + "║" + RESET);
        System.out.println(BLUE  + "  ║" + RESET + "  " + CYAN + "[4]" + RESET + "  🔄  Transfer Funds                         " + BLUE + "║" + RESET);
        System.out.println(BLUE  + "  ║" + RESET + "  " + RED  + "[5]" + RESET + "  🚪  Logout                                 " + BLUE + "║" + RESET);
        System.out.println(BLUE  + "  ╚══════════════════════════════════════════════════╝" + RESET);
    }

    public void printHistory(Account acc) {
        List<Transaction> history = acc.getHistory();
        System.out.println(YELLOW + "  ╔══════════════════════════════════════════════════════════════════╗" + RESET);
        System.out.printf (YELLOW + "  ║" + RESET + BOLD + "  📋 Transaction History — %-38s" + RESET + YELLOW + "║%n" + RESET, acc.getName());
        System.out.println(YELLOW + "  ╠═══════════════════╦══════════╦═══════════════╦══════════════════╣" + RESET);
        System.out.println(YELLOW + "  ║" + RESET + DIM + "  Date & Time      " + RESET + YELLOW + "║" + RESET + DIM + " Type     " + RESET + YELLOW + "║" + RESET + DIM + " Amount        " + RESET + YELLOW + "║" + RESET + DIM + " Balance          " + RESET + YELLOW + "║" + RESET);
        System.out.println(YELLOW + "  ╠═══════════════════╬══════════╬═══════════════╬══════════════════╣" + RESET);

        if (history.isEmpty()) {
            System.out.println(YELLOW + "  ║" + RESET + DIM + "  No transactions found.                                          " + RESET + YELLOW + "║" + RESET);
        } else {
            for (Transaction t : history) {
                String typeColor = t.getType().equals("CREDIT") ? GREEN : RED;
                String typeIcon  = t.getType().equals("CREDIT") ? "+" : "-";
                System.out.printf(YELLOW + "  ║" + RESET + " %-18s" + YELLOW + "║" + RESET
                        + typeColor + " %-9s" + RESET + YELLOW + "║" + RESET
                        + typeColor + " %s₹%-12.2f" + RESET + YELLOW + "║" + RESET
                        + " ₹%-17.2f" + YELLOW + "║%n" + RESET,
                        t.getTimestamp(), t.getType(), typeIcon, t.getAmount(), t.getBalanceAfter());
            }
        }
        System.out.println(YELLOW + "  ╚═══════════════════╩══════════╩═══════════════╩══════════════════╝" + RESET);
    }

    public void printResult(String[] result) {
        boolean ok = result[0].equals("OK");
        String color = ok ? GREEN : RED;
        String icon  = ok ? "✔" : "✘";
        System.out.println();
        System.out.println(color + "  ╔══════════════════════════════════════════════════╗" + RESET);
        System.out.printf (color + "  ║  %s  %-47s║%n" + RESET, icon, result[1]);
        System.out.println(color + "  ╚══════════════════════════════════════════════════╝" + RESET);
    }

    public void printLogout(String name) {
        System.out.println();
        System.out.println(CYAN + "  ╔══════════════════════════════════════════════════╗" + RESET);
        System.out.printf (CYAN + "  ║   👋 Goodbye, %-35s║%n" + RESET, name + "!");
        System.out.println(CYAN + "  ║      Thank you for banking with OIBSIP Bank.     ║" + RESET);
        System.out.println(CYAN + "  ╚══════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}