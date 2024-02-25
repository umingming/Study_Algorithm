package inflearn.DFSBFS활용;

import java.util.HashMap;
import java.util.Map;

import inflearn.재귀함수트리그래프.DFS;

/**
 * 5C3을 뽑는 경우의 수
 *
 * 3C2는?
 * 2C2 더하기 2C1
 * 1        2
 *
 */
public class 조합수 {

    static int[][] arr;

    public int DFS(int n, int r) {

        if (arr[n][r] > 0) {
            return arr[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        } else {
            return arr[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
        }

    }

    public static void main(String[] args) {
        조합수 solution = new 조합수();
        int n = 33;
        int m = 19;

        arr = new int[n+1][m+1];

        System.out.println(solution.DFS(n, m));
    }

}
