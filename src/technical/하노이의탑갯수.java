package technical;

import java.util.HashMap;
import java.util.Map;

/**
 * 원반 n개가 주어졌을 때 a -> c로 이동할 떄 필요한 최소한의 이동 갯수는?
 */
public class 하노이의탑갯수 {

    static Map<Integer, Integer> map = new HashMap<>();

    static int result = 0;

    public static void main(String[] args) {
        map.put(1, 1);
        map.put(2, 3);

        하노이의탑갯수 solution = new 하노이의탑갯수();
        System.out.println(solution.solution(3));
    }

    // f(n) = 1 + (2 * f(n-1))
    private int solution(int num) {
        if (!map.containsKey(num)) {
            map.put(num, 1 + (solution(num-1) * 2));
        } else {
            return map.get(num);
        }

        return map.get(num);
    }
}
