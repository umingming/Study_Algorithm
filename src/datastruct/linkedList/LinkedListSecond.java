package datastruct.linkedList;

public class LinkedListSecond {

    Node header;

    LinkedListSecond() {
        this.header = new Node();
    }
    static class Node {
        Object data;
        Node next = null;
    }


    public void append(Object data) {
        Node end = new Node();
        end.data = data;

        Node n = header;

        while(n.next != null) {
            n = n.next;
        }

        n.next = end;
    }

    public <T> void delete(T t) {
        Node n = header;

        while(n.next != null) {

            if (n.next.data.equals(t)) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    public void retrieve() {

        Node n = header.next;

        while(n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }

        System.out.print(n.data);

    }

    public static void main(String[] args) {
        LinkedListSecond ll = new LinkedListSecond();
        ll.append("asd");
        ll.append("asd");
        ll.append("asd");
        ll.append(456);


        ll.delete("asd");

        ll.retrieve();

    }



}
