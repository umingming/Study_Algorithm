package inflearn.재귀함수트리그래프;

import java.util.Arrays;
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
 *
 * 1. 제일 먼저 1을 Queue에 넣는다
 * 2. Queue에 넣은 값을 이차원 배열으로 순회하여 화살표가 어디를 가르키고 있는지 확인한다.
 * 2.1. results 배열을 확인하여 가르키고 있는 값이 값이 매겨져 있는지 확인하고 매겨져 있지 않으면 Queue에 넣는다.
 * 2.2. 매겨져 있으면 넣지 않는다.
 */
public class 그래프최단거리BFS2 {

    static int[][] arr = new int[][]
            {{0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 1, 1, 0, 0},
             {0, 1, 0, 0, 0, 1, 0},
             {0, 0, 0, 0, 1, 0, 0},
             {0, 0, 0, 0, 0, 1, 1},
             {0, 0, 0, 0, 0, 0, 0},
             {0, 0, 1, 0, 0, 1, 0}};

    static int[] results = new int[arr.length];

    public static void main(String[] args) {
        그래프최단거리BFS2 solution = new 그래프최단거리BFS2();

        int L = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; ++i) {
                Integer poll = queue.poll();
                results[poll] = L;
                solution.insertQueue(queue, poll);
            }
            L++;
        }

        for(int i=2; i<results.length; ++i) {
            System.out.println(i + "=" + results[i]);
        }
    }

    private void insertQueue(Queue<Integer> queue, int y) {
        for(int x=0; x<arr[y].length; ++x) {
            if (arr[y][x] == 1 && results[x] == 0) {
                queue.add(x);
            }
        }
    }

}
