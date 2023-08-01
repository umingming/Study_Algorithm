package search;


import java.util.*;

public class BFSExample {

    public static void main(String[] args) {
        // 그래프를 인접 리스트로 표현합니다.
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(1, 2));  // 노드 0에 연결된 노드들: 1, 2
        graph.add(Arrays.asList(0, 2, 3));  // 노드 1에 연결된 노드들: 0, 2, 3
        graph.add(Arrays.asList(0, 1, 3));  // 노드 2에 연결된 노드들: 0, 1, 3
        graph.add(Arrays.asList(1, 2, 4));  // 노드 3에 연결된 노드들: 1, 2, 4
        graph.add(Arrays.asList(3));  // 노드 4에 연결된 노드들: 3

        // BFS 탐색을 시작할 노드를 지정합니다.
        int startNode = 0;

        // BFS 탐색을 실행합니다.
        bfs(startNode, graph);
    }

    // BFS 탐색 함수
    public static void bfs(int startNode, List<List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];


        queue.offer(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            List<Integer> neighbors = graph.get(currentNode);
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}

