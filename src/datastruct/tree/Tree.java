package datastruct.tree;

public class Tree {

    int count;

    public Tree() {
        this.count = 0;
    }


    static class Node {

        Object data;
        Node leftNode;
        Node rightNode;

        Node(Object data) {
            this.data = data;
        }

        public void addLeftNode(Node node) {
            this.leftNode = node;
        }

        public void addRightNode(Node node) {
            this.rightNode = node;
        }

    }


}
