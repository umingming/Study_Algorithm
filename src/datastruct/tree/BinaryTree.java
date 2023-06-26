package datastruct.tree;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class Binary {
    Node root;

    public void traverseRecursionTree(Node node) {
        if (node != null) {
            traverseRecursionTree(node.left);
            System.out.print(" " + node.value);
            traverseRecursionTree(node.right);
        }
    }

    public static void main(String[] args) {
        Binary tree = new Binary();
        tree.root = new Node(10);
        tree.root.left = new Node(6);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(3);

        System.out.print("Binary Tree: ");
        tree.traverseRecursionTree(tree.root);
    }
}