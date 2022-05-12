package ch2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Node;

    //input: node c from a singly linkedList
    //output: No output
    //function: delete node c in linkedList (only access to that node)

public class DeleteMiddleNode {

    private static final Logger logger = LogManager.getLogger(DeleteMiddleNode.class);


    static class Node {
        Node next = null;
        int data;

        public Node (int d) {
            data = d;
        }

        void appendToTail (int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }


    }

    public static Boolean answer (Node n) {

        if (n == null) {
            logger.error("Node is null");
            return Boolean.FALSE;
        }

        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return Boolean.TRUE;
    }
}
