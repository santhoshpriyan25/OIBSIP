public class UI {

    // ANSI color codes
    public static final String RESET   = "\033[0m";
    public static final String BOLD    = "\033[1m";
    public static final String RED     = "\033[1;31m";
    public static final String GREEN   = "\033[1;32m";
    public static final String YELLOW  = "\033[1;33m";
    public static final String BLUE    = "\033[1;34m";
    public static final String MAGENTA = "\033[1;35m";
    public static final String CYAN    = "\033[1;36m";
    public static final String WHITE   = "\033[1;37m";
    public static final String DIM     = "\033[2m";
    public static final String BG_BLUE = "\033[44m";

    public static void print(String msg) {
        System.out.print(msg);
    }

    public static void println(String msg) {
        System.out.println(msg);
    }

    public static void printBanner() throws InterruptedException {
        clearScreen();
        System.out.println();
        System.out.println(CYAN + "  ╔══════════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "  ║" + RESET + BOLD + "         🎯  NUMBER  GUESSING  GAME  🎯           " + RESET + CYAN + "║" + RESET);
        System.out.println(CYAN + "  ╠══════════════════════════════════════════════════╣" + RESET);
        System.out.println(CYAN + "  ║" + RESET + DIM  + "    Can you crack the secret number? Let's go!   " + RESET + CYAN + "║" + RESET);
        System.out.println(CYAN + "  ║" + RESET + DIM  + "         Range: 1–100  |  Max attempts: 7        " + RESET + CYAN + "║" + RESET);
        System.out.println(CYAN + "  ║" + RESET + DIM  + "      Guess in fewer tries = more points!        " + RESET + CYAN + "║" + RESET);
        System.out.println(CYAN + "  ╚══════════════════════════════════════════════════╝" + RESET);
        System.out.println();
        Thread.sleep(300);
    }

    public static void printRoundHeader(int roundNum) {
        System.out.println();
        System.out.println(MAGENTA + "  ┌──────────────────────────────────────────────────┐" + RESET);
        System.out.printf (MAGENTA + "  │" + RESET + BOLD + "                  ★  ROUND  %2d  ★                  " + RESET + MAGENTA + "│%n" + RESET, roundNum);
        System.out.println(MAGENTA + "  └──────────────────────────────────────────────────┘" + RESET);
        System.out.println();
    }

    public static void printAttemptBar(int used, int max) {
        System.out.print("  Attempts  [");
        for (int i = 0; i < max; i++) {
            if (i < used)       System.out.print(RED   + "█" + RESET);
            else if (i == used) System.out.print(YELLOW + "░" + RESET);
            else                System.out.print(GREEN  + "░" + RESET);
        }
        System.out.println("]  " + DIM + (max - used) + " left" + RESET);
        System.out.println();
    }

    public static void printHintTooLow() {
        System.out.println();
        System.out.println(BLUE + "  ↑  Too LOW!   Go  H I G H E R  ↑" + RESET);
        System.out.println();
    }

    public static void printHintTooHigh() {
        System.out.println();
        System.out.println(RED + "  ↓  Too HIGH!  Go  L O W E R   ↓" + RESET);
        System.out.println();
    }

    public static void printWin(int attempts, int score) throws InterruptedException {
        System.out.println();
        System.out.println(GREEN + "  ╔══════════════════════════════════════════════════╗" + RESET);
        System.out.println(GREEN + "  ║   🎉  CORRECT!  You nailed it!                  ║" + RESET);
        System.out.printf (GREEN + "  ║   Guessed in %2d attempt(s)   |   +%3d pts        ║%n" + RESET, attempts, score);
        System.out.println(GREEN + "  ╚══════════════════════════════════════════════════╝" + RESET);
        System.out.println();
        Thread.sleep(400);
    }

    public static void printLose(int secret) throws InterruptedException {
        System.out.println();
        System.out.println(RED + "  ╔══════════════════════════════════════════════════╗" + RESET);
        System.out.println(RED + "  ║   💀  OUT OF ATTEMPTS!                          ║" + RESET);
        System.out.printf (RED + "  ║   The secret number was:  %-4d                  ║%n" + RESET, secret);
        System.out.println(RED + "  ╚══════════════════════════════════════════════════╝" + RESET);
        System.out.println();
        Thread.sleep(400);
    }

    public static void printGoodbye() {
        System.out.println();
        System.out.println(CYAN + "  ╔══════════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "  ║     Thanks for playing! See you next time 👋     ║" + RESET);
        System.out.println(CYAN + "  ╚══════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}