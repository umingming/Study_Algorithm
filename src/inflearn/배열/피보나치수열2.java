package inflearn.배열;

import java.util.HashMap;
import java.util.Map;

public class 피보나치수열2 {

    static Map<Integer, Integer> pivoMap = new HashMap<>();

    public static void main(String[] args) {
        pivoMap.put(1, 1);
        pivoMap.put(2, 1);
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        if (pivoMap.containsKey(n)) {
            return pivoMap.get(n);
        } else {
            pivoMap.put(n, solution(n-1) + solution(n-2));
        }

        return pivoMap.get(n);
    }
}
