package datastruct.stack.nodestack;

import java.util.EmptyStackException;

public class Stack2<T> {
    static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item) {
            this.item = item;
        }
    }

    private Node<T> last;

    public T pop() {
        if (last == null) {
            throw new EmptyStackException();
        }

        T item = last.item;
        last = last.next;
        return item;

    }

    public T peek() {
        if (last == null) {
            throw new EmptyStackException();
        }

        return last.item;
    }

//    public void push(T item) {
//        Node<T> item = new Node<T>(item);
//
//        last.next = last;
//    }

}
