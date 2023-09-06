package technical;

import java.util.HashMap;
import java.util.Map;

public class TopDownDynamicProgramming {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(topDownDp(4));
    }

    public static int topDownDp(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n <= 2) {
            return 1;
        }

        memo.put(n, topDownDp(n - 1) + topDownDp(n - 2));
        return memo.get(n);
    }

}
