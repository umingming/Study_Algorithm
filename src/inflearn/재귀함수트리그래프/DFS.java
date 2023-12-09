package inflearn.재귀함수트리그래프;

public class DFS {

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

    /**
     *       1
     *  2        3
     * 4 5      6 7
     *
     * 1. 전위순회
     *  - 1, 2, 4, 5, 3, 6, 7
     * 2. 중위순회
     *  - 4, 2, 5, 1, 3, 6, 7
     * 3. 후위순회
     *  - 4, 5, 2, 6, 7, 3, 1
     */
    public static void DFS(Node root) {

        if (root != null) {
            System.out.print(root.data + " -> ");
            DFS(root.lt);
            DFS(root.rt);
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
