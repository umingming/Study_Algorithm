package programmers.lv3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 인접 행렬로 풀어야하나?
 * DP?
 *
 * 갈 수 있는 곳들을 표시하기 위해서 3차원까지 써야하나?
 *
 */
public class 정수삼각형 {

    static int INIT_VALUE = -1;

    public static void main(String[] args) {
        정수삼각형 solution = new 정수삼각형();
        int[][] triangle = new int[][] { { 7 },
                                         { 3, 8 },
                                         { 8, 1, 0 },
                                         { 2, 7, 4, 4 },
                                         { 4, 5, 2, 6, 5 } };

        int answer = solution.solution(triangle);
        System.out.println(answer);
    }

    public int solution(int[][] triangle) {
        int[][] result = new int[triangle.length+1][triangle.length+1];

        for (int[] ints : result) {
            Arrays.fill(ints, INIT_VALUE);
        }

        return DFS(triangle, 0, 0, result);
    }

    /**
     * DP 돌 때 메모이제이션 처리
     */
    private int DFS(int[][] triangle, int x, int y, int[][] result) {
        if (y == triangle.length) {
            return 0;
        }

        if (result[y][x] != INIT_VALUE) {
            return result[y][x];
        }

        int leftNodeValue = DFS(triangle, x, y+1, result);
        int rightNodeValue = DFS(triangle, x+1, y+1, result);

        result[y][x] = triangle[y][x] + Math.max(leftNodeValue, rightNodeValue);

        return result[y][x];
    }

}
