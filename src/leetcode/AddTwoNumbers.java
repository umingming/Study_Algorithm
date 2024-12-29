package leetcode;

public class AddTwoNumbers {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            ListNode current = this;
            while (current != null) {
                sb.append(current.val);
                if (current.next != null) sb.append(", ");
                current = current.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        // Example 1:
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        AddTwoNumbers solution = new AddTwoNumbers();
        System.out.println("Example 1 Output: " + solution.addTwoNumbers(l1, l2)); // Expected: [7,0,8]

        // Example 2:
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);
        System.out.println("Example 2 Output: " + solution.addTwoNumbers(l3, l4)); // Expected: [0]

        // Example 3:
        ListNode l5 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l6 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        System.out.println("Example 3 Output: " + solution.addTwoNumbers(l5, l6)); // Expected: [8,9,9,9,0,0,0,1]

        ListNode l7 = new ListNode(1, new ListNode(0));
        ListNode l8 = new ListNode(1);
        System.out.println("Example 3 Output: " + solution.addTwoNumbers(l7, l8));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode currentNode = dummyHead;

        int nextNum = 0;

        while(l1 != null || l2 != null) {

            int l1Num = l1 == null ? 0 : l1.val;
            int l2Num = l2 == null ? 0 : l2.val;

            // 이전 자릿수에서 넘어온 값과 현재 자릿수로 가정한 값들을 모두 더한 값
            int sum = nextNum + l1Num + l2Num;

            // 현재 자릿수
            int currnetNum = sum % 10;
            // 다음 자릿수로 넘겨줄 값
            nextNum = sum / 10;

            currentNode.next = new ListNode(currnetNum);
            currentNode = currentNode.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (nextNum != 0) {
            currentNode.next = new ListNode(nextNum);
        }

        return dummyHead.next;
    }
}
