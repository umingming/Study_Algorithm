package inflearn.DFSBFS활용;

import java.util.HashMap;
import java.util.Map;

/**
 * 5C3을 구해보자
 * nCr = n-1Cr-1 + n-1Cr
 */
public class 조합수2 {

    static int[][] arr;
    static Map<String, Integer> map = new HashMap<>();

    public static int DFS(int n, int r) {
        String key = n + "," + r;
        if (map.getOrDefault(key, 0) > 0) {
            return map.get(key);
        }

        if (n == r || r == 0) {
            map.put(key, 1);
        } else {
            map.put(key, DFS(n-1, r-1) + DFS(n-1, r));
        }
        return map.get(key);

    }

    public static void main(String[] args) {
        int n = 5;
        int r = 3;
        arr = new int[n+1][r+1];
        System.out.println(DFS(n, r));
    }
}
