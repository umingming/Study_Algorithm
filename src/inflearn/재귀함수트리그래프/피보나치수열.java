package inflearn.재귀함수트리그래프;

import java.util.HashMap;
import java.util.Map;

/**
 * 7 입력 시
 * 1 1 2 3 5 8 13
 *
 * 1. 처음에 1을 찍으려면 어떻게 해야하지?
 *  1.1. n이 1이면 1을 찍는다?
 * 2. 어떻게 하면 n을 점점 값을 추가해 나갈 수 있지?
 *  2.1. 계단 올라가는 다이나믹 프로그래밍이랑 같은거 아닌가?
 */
public class 피보나치수열 {


    // 7일 때
    // n에 값 있는지 확인
    //  없으면?
    // n-1에 값 있는지 확인
    private static Map<Integer, Integer> cache = new HashMap<>();

    public static int DFSRef(int n) {
        if (n <= 2) {
            return 1;
        } else if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            int result = DFSRef(n - 1) + DFSRef(n - 2);
            cache.put(n, result);
            return result;
        }
    }

    //n번째 항이 나오게 하는 방법
    public static int DFS(int n) {

        if (n == 1 || n == 2) {
            return 1;
        } else {
            return DFS(n-2) + DFS(n-1);
        }

    }

    public static void main(String[] args) {

//        System.out.println(DFS(7));
        System.out.println(DFSRef(7));
    }

}
