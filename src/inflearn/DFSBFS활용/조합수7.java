package inflearn.DFSBFS활용;

import java.util.HashMap;
import java.util.Map;

/**
 * nCr = n-1Cr + n-1Cr-1
 */
public class 조합수7 {

    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        조합수7 solution = new 조합수7();

        int n = 5;
        int r = 3;

        System.out.println(solution.DFS(n, r));
    }

    public int DFS(int n, int r) {
        String key = n + "," + r;

        if (map.containsKey(n + "-" + r)){
            return map.get(key);
        }

        if (n == r || r == 0) {
            map.put(key, 1);
        } else {
            map.put(key, DFS(n-1, r) + DFS(n-1, r-1));
        }

        return map.get(key);
    }

}
