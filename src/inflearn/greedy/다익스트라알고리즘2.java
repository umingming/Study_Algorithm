package inflearn.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 아래의 가중치 방향 그래프에서 1번 정점에서 모든 정점으로의 최소 거리 비용을 출력하는 프로그램을 작성하세요
 */
public class 다익스트라알고리즘2 {
    static class Edge implements Comparable<Edge> {
        int target;
        int value;

        public Edge(int target, int value) {
            this.target = target;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }

    static int[] dis;
    static List<List<Edge>> edgeList = new ArrayList<>();

    public static void main(String[] args) {
        int edgeCount = 9;
        int[][] edgeInfo = {
                {1, 2, 12},
                {1, 3, 4},
                {2, 1, 2},
                {2, 3, 5},
                {3, 4, 5},
                {4, 2, 2},
                {4, 5, 5},
                {4, 6, 5},
                {6, 4, 5}
        };

        다익스트라알고리즘2 solution = new 다익스트라알고리즘2();
        solution.init(edgeCount, edgeInfo);
        solution.solution();
        solution.resultPrint();

    }

    public void init(int edgeCount, int[][] edgeInfo) {
        for(int i=0; i<edgeCount+1; ++i) {
            edgeList.add(new ArrayList<>());
        }

        dis = new int[7];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int[] edge : edgeInfo) {
            for(int i=0; i<edge.length; ++i) {
                int startNode = edge[0];
                int endNode = edge[1];
                int value = edge[2];

                edgeList.get(startNode).add(new Edge(endNode, value));
            }
        }

    }

    public void solution() {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(1, 0));
        dis[1] = 0;

        while (!queue.isEmpty()) {
            Edge poll = queue.poll();

            int currentTarget = poll.target;
            int currentValue = poll.value;

            if (dis[currentTarget] > currentValue) {
                continue;
            }

            for(Edge edge : edgeList.get(currentTarget)) {
                int nextTarget = edge.target;
                int nextValue = edge.value;

                if (dis[nextTarget] > currentValue + nextValue) {
                    dis[nextTarget] = currentValue + nextValue;
                    queue.add(new Edge(nextTarget, currentValue + nextValue));
                }
            }
        }
    }

    public void resultPrint() {
        for(int i=2; i<dis.length; ++i) {
            if (dis[i] == Integer.MAX_VALUE) {
                System.out.println(i + "번째는 Impossible");
            } else {
                System.out.println(i + "번째는 " + dis[i]);
            }
        }
    }

}
