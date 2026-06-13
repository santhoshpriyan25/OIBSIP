import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        ScoreBoard scoreBoard = new ScoreBoard();

        UI.printBanner();
        Thread.sleep(500);

        String playAgain = "y";
        while (playAgain.equalsIgnoreCase("y")) {
            GameRound round = new GameRound(sc);
            int score = round.play();
            scoreBoard.addScore(score);

            System.out.println();
            UI.print(UI.YELLOW + "  Play another round? (y/n): " + UI.RESET);
            playAgain = sc.next().trim();
        }

        scoreBoard.printSummary();
        UI.printGoodbye();
        sc.close();
    }
}