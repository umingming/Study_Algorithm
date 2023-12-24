package inflearn.재귀함수트리그래프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSMemory {

    static Node root;

    static class Node {
        int data;
        Node lt;
        Node rt;

        Node(int data) {
            this.data = data;
            lt = null;
            rt = null;
        }
    }


    public static void DFS(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);


        while (!stack.isEmpty()) {
            /**
             *       1
             *  2        3
             * 4 5      6 7
             */

            Node pop = stack.pop();
            System.out.print(pop.data + " -> ");

            if (pop.rt != null) {
                stack.push(pop.rt);
            }
            if (pop.lt != null) {
                stack.push(pop.lt);
            }

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
        DFS(root);
    }

}
