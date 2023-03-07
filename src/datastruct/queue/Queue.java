package datastruct.queue;

import java.util.NoSuchElementException;

public class Queue<T> {

    static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;


    public void add(T data) {
        Node<T> n = new Node<>(data);

        if (last != null) {
            last.next = n;
        }
        //이 순간 기존의 last는 last가 아닌게 되는거구나
        last = n;

        if (first == null) {
            first = last;
        }
    }

    public void remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        first = first.next;

        if (first == null) {
            last = null;
        }
    }

    public T element() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        return first.data;
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public T poll() {
        if (first == null) {
            return null;
        }

        T data = first.data;
        first = first.next;

        if (first == null) {
            last = null;
        }

        return data;
    }

    public void clear() {
        first = null;
        last = null;
    }


}
