package programmers.lv3.길찾기게임;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class 길찾기게임2 {

    static class Node implements Comparable<Node> {

        int x;
        int y;
        int value;

        Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        Node lt;

        Node rt;

        @Override
        public int compareTo(Node o) {
            if (this.y > o.y) {
                return -1;
            } else if (this.y == o.y) {
                if (this.x > o.x) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                   "x=" + x +
                   ", y=" + y +
                   ", value=" + value +
                   ", lt=" + lt +
                   ", rt=" + rt +
                   '}';
        }
    }

    public static void main(String[] args) {
        길찾기게임2 solution = new 길찾기게임2();
        int[][] nodeInfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 }, { 2, 2 } };
        solution.solution(nodeInfo);
    }

    private void solution(int[][] nodeInfo) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < nodeInfo.length; i++) {
            nodeList.add(new Node(nodeInfo[i][0], nodeInfo[i][1], i));
        }

        nodeList = nodeList.stream()
                           .sorted()
                           .collect(Collectors.toList());

        Node root = nodeList.get(0);

        for(int i=1; i<nodeInfo.length; i++) {
            insertNode(root, nodeList.get(i));
        }

        printNode(nodeList.get(0));
    }

    private void insertNode (Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.lt == null) {
                parent.lt = child;
            } else {
                insertNode(parent.lt, child);
            }
        } else {
            if (parent.rt == null) {
                parent.rt = child;
            } else {
                insertNode(parent.rt, child);
            }
        }
    }

    private void printNode(Node node) {
        if (node != null) {
            System.out.println(node.value);
            printNode(node.lt);
            printNode(node.rt);
        }
    }
}
