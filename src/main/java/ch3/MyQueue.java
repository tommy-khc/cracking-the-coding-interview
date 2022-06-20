package ch3;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode (T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add (T item) { //understand it, it is a bit hard
        QueueNode<T> t = new QueueNode<T>(item);
        if (last != null) {
            last.next = t; //After the first addition (1), then for the second addition (2), first = last -> last.next = t -> first.next = t
        }                   //(3) last.next (second QueueNode's next) = t (third QueueNode)
        last = t; //(2) last = t
        if (first == null) {
            first = last;
        }
    }

    public T remove () {
        if (first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
