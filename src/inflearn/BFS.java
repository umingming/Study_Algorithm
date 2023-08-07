package inflearn;

public class BFS {

    public static class Node {
        Node lf;
        Node rf;
        Object data = null;

        Node(Object data) {
            this.data = data;
            this.lf = null;
            this.rf = null;
        }

        public Node getLf() {
            return lf;
        }

        public void setLf(Node lf) {
            this.lf = lf;
        }

        public Node getRf() {
            return rf;
        }

        public void setRf(Node rf) {
            this.rf = rf;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lf = new Node(2);
        root.rf = new Node(3);
        root.lf.lf = new Node(4);
        root.lf.rf = new Node(5);
        root.rf.lf = new Node(6);
        root.rf.rf = new Node(7);
        DFS(root);
    }

    //1
    //2 3
    //45 67

    public static void DFS(Node node) {
        if (node == null) return;

        System.out.println("node data = " + node.data);
        DFS(node.lf);
        DFS(node.rf);
    }

}
