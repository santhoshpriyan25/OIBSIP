import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreBoard {
    private final List<Integer> scores = new ArrayList<>();

    public void addScore(int score) {
        scores.add(score);
    }

    public void printSummary() {
        int total = scores.stream().mapToInt(Integer::intValue).sum();
        int best  = scores.isEmpty() ? 0 : Collections.max(scores);
        int rounds = scores.size();

        System.out.println();
        System.out.println(UI.YELLOW + "  ╔══════════════════════════════════════════════════╗" + UI.RESET);
        System.out.println(UI.YELLOW + "  ║" + UI.RESET + UI.BOLD  + "                  📊  SCOREBOARD                  " + UI.RESET + UI.YELLOW + "║" + UI.RESET);
        System.out.println(UI.YELLOW + "  ╠══════════════════════════════════════════════════╣" + UI.RESET);

        for (int i = 0; i < scores.size(); i++) {
            int s = scores.get(i);
            String bar = buildBar(s);
            System.out.printf(UI.YELLOW + "  ║" + UI.RESET + "  Round %2d │ %s %3d pts  " + UI.YELLOW + "║%n" + UI.RESET,
                    i + 1, bar, s);
        }

        System.out.println(UI.YELLOW + "  ╠══════════════════════════════════════════════════╣" + UI.RESET);
        System.out.printf (UI.YELLOW + "  ║" + UI.RESET + UI.GREEN  + "  ✔  Total Score  : %-5d                         " + UI.RESET + UI.YELLOW + "║%n" + UI.RESET, total);
        System.out.printf (UI.YELLOW + "  ║" + UI.RESET + UI.CYAN   + "  ★  Best Round   : %-5d                         " + UI.RESET + UI.YELLOW + "║%n" + UI.RESET, best);
        System.out.printf (UI.YELLOW + "  ║" + UI.RESET + UI.DIM    + "  #  Rounds Played: %-5d                         " + UI.RESET + UI.YELLOW + "║%n" + UI.RESET, rounds);
        System.out.println(UI.YELLOW + "  ╚══════════════════════════════════════════════════╝" + UI.RESET);
    }

    private String buildBar(int score) {
        int filled = score / 15;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            if (i < filled) sb.append(UI.GREEN + "█" + UI.RESET);
            else            sb.append(UI.DIM   + "░" + UI.RESET);
        }
        return sb.toString();
    }
}