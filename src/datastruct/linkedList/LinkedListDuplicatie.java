package datastruct.linkedList;

public class LinkedListDuplicatie {

    Node header;

    LinkedListDuplicatie() {
        this.header = new Node();
    }

    static class Node {
        Object data;
        Node next = null;
    }

    void append(Object data) {
        Node end = new Node();
        end.data = data;

        Node n = header;

        while(n.next != null) {
            n = n.next;
        }

        n.next = end;
    }

    void delete(Object data) {
        Node n = header;

        while(n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        Node n = header.next;

        while(n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }

        System.out.println(n.data);
    }

    void deleteDuplicate(Object data) {

        Node n = header.next;
        Node r = header.next;

        while(n.next != null) {

            while (r.next!=null) {
                if (n.next.data == data) {
                    n.next = n.next.next;
                }
            }
            n = n.next;
        }

    }


    public static void main(String[] args) {
        LinkedListDuplicatie ll = new LinkedListDuplicatie();
        ll.append(1);
        ll.append(1);
        ll.append(1);
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.deleteDuplicate(1);

        ll.delete(2);

        ll.retrieve();
    }
}
