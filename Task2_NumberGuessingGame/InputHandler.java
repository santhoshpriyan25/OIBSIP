import java.util.Scanner;

public class InputHandler {
    public static int getValidInt(Scanner sc) {
        while (true) {
            try {
                int val = Integer.parseInt(sc.next().trim());
                if (val >= 1 && val <= 100) return val;
                System.out.print(UI.RED + "  ⚠  Enter a number between 1 and 100: " + UI.RESET);
            } catch (NumberFormatException e) {
                System.out.print(UI.RED + "  ⚠  Invalid! Enter a number: " + UI.RESET);
            }
        }
    }
}