package inflearn.재귀함수트리그래프;

public class 트리말단노드까지의가장짧은경로 {

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

//    public static int DFS(Node node, int L) {
//        if (node.lt != null && node.rt != null) {
//            L++;
//            DFS(node.lt, L);
//            DFS(node.rt, L);
//        } else {
//            if (min > L) {
//                min = L;
//            }
//        }
//        return min;
//    }


    public static int DFS(Node node, int L) {
        if (node.lt == null && node.rt == null) {
            return L;
        } else {
            return Math.min(DFS(node.lt, L+1), DFS(node.rt, L+1));
        }
    }


    public static void main(String[] args) {
        root = new Node(1);
        // 들어온다.
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
//        root.rt.lt = new Node(4);
//        root.rt.rt = new Node(5);

        System.out.println(DFS(root, 0));
    }

}
