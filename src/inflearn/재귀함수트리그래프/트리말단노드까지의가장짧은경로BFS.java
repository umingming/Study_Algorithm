package inflearn.재귀함수트리그래프;

import java.util.LinkedList;
import java.util.Queue;

public class 트리말단노드까지의가장짧은경로BFS {

    static Node root;
    static int min = Integer.MAX_VALUE;

    static class Node {
        Node lt;
        Node rt;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static int BFS(Node node) {

        int LV = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; ++i) {
                Node target = queue.poll();

                if (target.lt == null && target.rt == null) {
                    return LV;
                } else if (target.lt != null && target.rt == null){
                    queue.add(target.lt);
                } else if (target.lt == null && target.rt != null){
                    queue.add(target.rt);
                } else {
                    queue.add(target.lt);
                    queue.add(target.rt);
                }
            }

            LV++;
        }

        return LV;

    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(4);
        root.rt.rt = new Node(5);

        System.out.println(BFS(root));

    }

}
