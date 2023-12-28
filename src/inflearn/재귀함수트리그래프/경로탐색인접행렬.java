package inflearn.재귀함수트리그래프;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 경로탐색인접행렬 {

    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;

    public static void DFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for(int i=1; i<=n; ++i) {
                // 인접 행렬이 해당 노드가 있다는 것을 알려주고 있고, 아직 방문하지 않은 것이면
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 정점의 갯수
        n = 5;
        // 간선의 갯수
        m = 9;

        graph = new int[n+1][n+1];
        ch = new int[n+1];


        /**
         * 1 2
         * 1 3
         * 1 4
         * 2 1
         * 2 3
         * 2 5
         * 3 4
         * 4 2
         * 4 5
         *
         * 0 0 0 0 0 0
         * 0 0 1 1 1 0
         * 0 1 0 1 0 1
         * 0 0 0 0 1 0
         * 0 0 1 0 0 1
         * 0 0 0 0 0 0
         */
        graph[1][2] = 1;
        graph[1][3] = 1;
        graph[1][4] = 1;
        graph[2][1] = 1;
        graph[2][3] = 1;
        graph[2][5] = 1;
        graph[3][4] = 1;
        graph[4][2] = 1;
        graph[4][5] = 1;

        ch[1] = 1;
        DFS(1);
        System.out.println(answer);
    }

}
