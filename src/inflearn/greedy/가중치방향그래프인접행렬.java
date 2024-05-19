package inflearn.greedy;

import java.util.Arrays;

/**
 * 아래의 가중치 방향 그래프에서 1번 정점에서 모든 정점으로의 최소 거리 비용을 출력하는 프로그램을 작성하시오.
 *
 * [풀이]
 * 1. 그래프를 나타낼 수 있는 인접 행렬(이차원 배열)을 생성한다.
 * 2. result 배열(각 정점들의 최소 거리 비용을 담은 배열)을 생성한다.
 * 3. 계속 돌아준다.
 *  3.1. 1번부터 6번까지 가는 방법은 없는데 어떻게 알 수 있나?
 *      3.1.1. L이 정점 갯수를 넘으면 종료
 */
public class 가중치방향그래프인접행렬 {

    static int[] result = new int[7];

    public static void main(String[] args) {
        가중치방향그래프인접행렬 solution = new 가중치방향그래프인접행렬();
        int[][] graph = new int[7][7];

        solution.init(graph);
        solution.resultInit();

        solution.DFS(graph, 1, 0, 0);

        for(int i=2; i<result.length; ++i) {
            if (result[i] != Integer.MAX_VALUE) {
                System.out.println(i + ": " + result[i]);
            } else {
                System.out.println(i + ": " + "Impossible");
            }
        }
    }

    private void DFS(int[][] graph, int target, int sum, int L) {
        if (L == 6) {
            return;
        } else {
            for(int i=1; i<graph[target].length; ++i) {
                if (graph[target][i] != 0) {
                    int resultSum = sum + graph[target][i];
                    result[i] = Math.min(result[i], resultSum);
                    DFS(graph, i, resultSum, L+1);
                }
            }
        }
    }

    private void init(int[][] graph) {
        graph[1][2] = 12;
        graph[1][3] = 4;

        graph[2][3] = 5;
        graph[2][5] = 5;

        graph[3][4] = 5;

        graph[4][2] = 2;
        graph[4][5] = 5;

        graph[6][4] = 5;
    }

    private void resultInit() {
        Arrays.fill(result, Integer.MAX_VALUE);
    }
}
