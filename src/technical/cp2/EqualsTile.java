package technical.cp2;

import java.util.HashSet;
import java.util.Set;

public class EqualsTile {

    public String solution(String[] A) {
        Set<String> uniqueTiles = new HashSet<>();

        for (String tile : A) {
            String[] parts = tile.split("-");
            String isFormattingTile = Math.min(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])) + "-" + Math.max(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            uniqueTiles.add(isFormattingTile);
        }

        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                String currentTile = i + "-" + j;
                if (!uniqueTiles.contains(currentTile)) {
                    return currentTile;
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        Main solution = new Main();
        String[] testCase1 = {"0-0", "0-1", "2-3", "2-0"};
        String[] testCase2 = {"0-0", "1-1", "2-2", "3-3", "4-4", "5-5", "6-6"};
        System.out.println(solution.solution(testCase1));
        System.out.println(solution.solution(testCase2));
    }

}
