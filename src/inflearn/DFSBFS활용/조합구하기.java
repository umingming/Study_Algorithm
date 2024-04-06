package inflearn.DFSBFS활용;

import java.util.List;

import inflearn.재귀함수트리그래프.DFS;

/**
 * 1부터 N까지 번호가 적힌 구슬이 있습니다.
 *
 * 이 중 M개를 뽑는 방법의 수를 출력하는 프로그을 작성하세요
 */
public class 조합구하기 {

    static int[] result;
    static int N, M;

    private void DFS() {
        DFS(0, 1);
    }

    private void DFS(int L, int S) {
        if (L == M) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for(int i=S; i<=N; ++i) {
                result[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        N = 15;
        M = 2;

        result = new int[M];

        조합구하기 solution = new 조합구하기();
        solution.DFS();
        System.out.println(solution.combiNum(N, M));
    }

    public int combiNum(int N, int M) {
        if (N == M || M == 0) {
            return 1;
        }

        return combiNum(N-1, M-1) + combiNum(N-1, M);
    }
}
