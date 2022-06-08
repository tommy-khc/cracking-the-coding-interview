package answerFromBook.ch2;

public class Node {

    Node next = null;
    char data;

    public Node (char d) {
        data = d;
    }

    public Boolean hasNext() {
        return next == null ? Boolean.FALSE : Boolean.TRUE;
    }

    public String convertDataToString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

}
