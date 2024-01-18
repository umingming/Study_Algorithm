package inflearn.재귀함수트리그래프;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 설명
 * 다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요
 * 0 0 0 0 0 0 0
 * 0 0 0 1 1 0 0
 * 0 1 0 0 0 1 0
 * 0 0 0 1 0 0 0
 * 0 0 0 0 1 1 0
 * 0 0 0 0 0 0 0
 * 0 0 1 0 0 1 0
 */
public class 그래프최단거리BFS {

    public static boolean[][] graph = new boolean[7][7];

    public static int BFS(int end) {
        int result = 0;
        int L = 1;

        Queue<Integer> queue = new LinkedList<>();
        insertQueue(queue, 1);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; ++i) {
                Integer poll = queue.poll();
                if (poll == end) {
                    result = L;
                    return result;
                } else {
                    insertQueue(queue, poll);
                }
            }
            ++L;
        }

        return result;
    }

    public static void insertQueue(Queue<Integer> queue, int y) {
        for(int i=0; i<graph[y].length; ++i) {
            boolean target = graph[y][i];
            if (target) {
                queue.add(i);
            }
        }
    }

    public static void main(String[] args) {
        graph[1][3] = true;
        graph[1][4] = true;
        graph[2][1] = true;
        graph[2][5] = true;
        graph[3][4] = true;
        graph[4][5] = true;
        graph[4][6] = true;
        graph[6][2] = true;
        graph[6][5] = true;

        System.out.println(BFS(2));
    }
}
