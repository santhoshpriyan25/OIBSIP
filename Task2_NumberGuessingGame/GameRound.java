import java.util.Random;
import java.util.Scanner;

public class GameRound {
    private static final int MAX_ATTEMPTS = 7;
    private final int secretNumber;
    private final Scanner sc;
    private static int roundCount = 0;

    public GameRound(Scanner sc) {
        this.sc = sc;
        this.secretNumber = new Random().nextInt(100) + 1;
        roundCount++;
    }

    public int play() throws InterruptedException {
        UI.printRoundHeader(roundCount);
        System.out.println(UI.DIM + "  🔒 I've locked in a secret number between 1 and 100." + UI.RESET);
        System.out.println();

        int attempts = 0;
        boolean won = false;

        while (attempts < MAX_ATTEMPTS) {
            UI.printAttemptBar(attempts, MAX_ATTEMPTS);
            System.out.print(UI.WHITE + "  ➤  Your guess: " + UI.RESET);

            int guess = InputHandler.getValidInt(sc);
            attempts++;

            if (guess == secretNumber) {
                won = true;
                break;
            } else if (guess < secretNumber) {
                UI.printHintTooLow();
            } else {
                UI.printHintTooHigh();
            }
        }

        int score = 0;
        if (won) {
            score = calculateScore(attempts);
            UI.printWin(attempts, score);
        } else {
            UI.printLose(secretNumber);
        }
        return score;
    }

    private int calculateScore(int attempts) {
        return Math.max(10, (MAX_ATTEMPTS - attempts + 1) * 15);
    }
}