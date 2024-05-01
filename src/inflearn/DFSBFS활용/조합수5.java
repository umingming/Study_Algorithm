package inflearn.DFSBFS활용;

import java.util.HashMap;
import java.util.Map;

/**
 * 5C3을 뽑는 경우의 수
 *
 * 3C2는?
 * 2C2 더하기 2C1
 * 1        2
 *
 * [풀이]
 * 1. nCr = n-1Cr + n-1Cr-1
 */
public class 조합수5 {

    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        조합수5 solution = new 조합수5();
        System.out.println(solution.DFS(5, 2));
    }

    public int DFS(int n, int r) {
        String key = n+","+r;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (n == r || r <= 0) {
            map.put(key, 1);
        } else {
            map.put(key, DFS(n-1, r-1) + DFS (n-1, r));
        }

        return map.get(key);
    }

}
