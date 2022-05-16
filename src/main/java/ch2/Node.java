package ch2;

public class Node {

    Node next = null;
    char data;

    public Node (char d) {
        data = d;
    }

    void appendToTail (char d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public Boolean hasNext() {
        return next == null ? Boolean.FALSE : Boolean.TRUE;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
    
}
