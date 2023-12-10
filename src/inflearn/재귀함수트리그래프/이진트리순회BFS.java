package inflearn.재귀함수트리그래프;


import java.util.LinkedList;
import java.util.Queue;

/**
 *    1
 * 2     3
 * 4 5  6 7
 *
 * 이렇게 있을 때 레벨 탐색하도록 1, 2, 3, 4, 5, 6, 7순으로 순회할 것.
 */

public class 이진트리순회BFS {

    static Node root;

    static class Node {
        int data = 0;
        Node lt, rt;
        public Node(int data) {
            this.data = data;
            lt = null;
            rt = null;
        }

    }

    public static void BFS(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print(L + " : ");

            // 여기서 queue.size를 해주면 for문이 한번씩 돌 때마다 갱신된다.
            // 하긴 for문은 표현식이니까 반복문 돌 때마다 queue.size메소드를 호출해주겠지
            // 당연한건데 신기하다
            for(int i=0; i<len; ++i) {
                Node cur = queue.poll();
                System.out.print(cur.data+ " ");
                if (cur.lt != null) queue.add(cur.lt);
                if (cur.rt != null) queue.add(cur.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        BFS(root);
    }


}
