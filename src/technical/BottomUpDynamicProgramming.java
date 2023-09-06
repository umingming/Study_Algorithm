package technical;

import java.util.HashMap;
import java.util.Map;

public class BottomUpDynamicProgramming {

    public static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(bottomUpDp(9));
    }

    public static int bottomUpDp(int n) {

        memo.put(1, 1);
        memo.put(2, 2);

        for(int i=3; i<=n; ++i) {
            memo.put(i, memo.get(i-1) + memo.get(i-2));
        }

        return memo.get(n);

    }

}
