import java.util.Scanner;

public class ATM {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        UI ui = new UI();

        ui.printWelcome();

        Account currentAccount = null;
        int loginAttempts = 0;

        while (currentAccount == null && loginAttempts < 3) {
            System.out.print(UI.WHITE + "  User ID  : " + UI.RESET);
            String userId = sc.next().trim();
            System.out.print(UI.WHITE + "  PIN      : " + UI.RESET);
            String pin = sc.next().trim();

            currentAccount = bank.login(userId, pin);
            if (currentAccount == null) {
                loginAttempts++;
                int left = 3 - loginAttempts;
                System.out.println();
                System.out.println(UI.RED + "  ✘  Wrong credentials. Attempts remaining: " + left + UI.RESET);
                System.out.println();
            }
        }

        if (currentAccount == null) {
            System.out.println(UI.RED + "\n  🔒 Card blocked! Please contact your bank.\n" + UI.RESET);
            sc.close();
            return;
        }

        ui.printLoginSuccess(currentAccount.getName());
        Thread.sleep(600);

        boolean running = true;
        while (running) {
            ui.printMenu(currentAccount);
            System.out.print(UI.WHITE + "  ➤  Choose option: " + UI.RESET);
            String choice = sc.next().trim();

            System.out.println();
            switch (choice) {
                case "1":
                    ui.printHistory(currentAccount);
                    break;
                case "2":
                    System.out.print(UI.CYAN + "  Enter withdrawal amount  ₹: " + UI.RESET);
                    double wAmt = getPositiveDouble(sc);
                    ui.printResult(bank.withdraw(currentAccount, wAmt));
                    break;
                case "3":
                    System.out.print(UI.CYAN + "  Enter deposit amount     ₹: " + UI.RESET);
                    double dAmt = getPositiveDouble(sc);
                    ui.printResult(bank.deposit(currentAccount, dAmt));
                    break;
                case "4":
                    System.out.print(UI.CYAN + "  Enter recipient User ID   : " + UI.RESET);
                    String toId = sc.next().trim();
                    System.out.print(UI.CYAN + "  Enter transfer amount    ₹: " + UI.RESET);
                    double tAmt = getPositiveDouble(sc);
                    ui.printResult(bank.transfer(currentAccount, toId, tAmt));
                    break;
                case "5":
                    ui.printLogout(currentAccount.getName());
                    running = false;
                    break;
                default:
                    System.out.println(UI.RED + "  ⚠  Invalid option. Choose 1–5." + UI.RESET);
            }

            if (running) {
                System.out.println();
                System.out.print(UI.DIM + "  Press ENTER to continue..." + UI.RESET);
                try { System.in.read(); sc.nextLine(); } catch (Exception ignored) {}
            }
        }
        sc.close();
    }

    private static double getPositiveDouble(Scanner sc) {
        while (true) {
            try {
                double val = Double.parseDouble(sc.next().trim());
                if (val > 0) return val;
                System.out.print(UI.RED + "  ⚠  Amount must be positive ₹: " + UI.RESET);
            } catch (NumberFormatException e) {
                System.out.print(UI.RED + "  ⚠  Invalid! Enter amount   ₹: " + UI.RESET);
            }
        }
    }
}