package ch2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Partition {

    private static final Logger logger = LogManager.getLogger(Partition.class);

    public static class Node {
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

    public static class LinkedList {
        Node head;

        public int GetNth(int index) {
            Node current = head;
            int count = 0;
            while (current != null) {
                if (count == index)
                    return current.data;
                count++;
                current = current.next;
            }

            assert (false);
            return 0;
        }

        public Node GetNthNode (int index) {
            Node current = head;
            int count = 0;
            while (current != null) {
                if (count == index)
                    return current;
                count++;
                current = current.next;
            }

            assert (false);
            return null;
        }

        public Node GetTail() {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            return current;
        }

        private Boolean remove (Node n) {
            if (n == null) {
                logger.error("Node is null");
                return Boolean.FALSE;
            }

            Node next = n.next;
            n.data = next.data;
            n.next = next.next;
            return Boolean.TRUE;
        }

        public void appendToTail(int new_data) {

            //Head won't be changed

            if (head == null) {
                head = new Node(new_data);
                return;
            }

            head.appendToTail(new_data);
        }

        public void appendToHead(int new_data) {

            //head is changed

            Node newHead = new Node(new_data);
            newHead.next = head;
            head = newHead;

        }

        public List<String> toDeepString () {
            List<String> list = new ArrayList<>();
            Node n = head;
            list.add(n.toString());
            while (n.next != null) {
                list.add(n.next.toString());
                n = n.next;
            }
            return list;
        }

    }

    public static LinkedList answer (int partition, LinkedList list) {

        if (list == null) {
            logger.error("list is null");
            return null;
        }

        if (list.head == null) {
            logger.error("head is null");
            return list;
        }

        Node current = list.head;
        Node end = list.GetTail();
        Boolean endLoop = false;
        do {
            if (current.data < partition) {
                list.appendToHead(current.data);
            } else { //current.data >= partition
                list.appendToTail(current.data);
            }

            list.remove(current);
            logger.debug(list.toDeepString());

            if (current.next.equals(end)) {
                endLoop = true;
            }
        } while (!endLoop);

        return list;
    }

}
