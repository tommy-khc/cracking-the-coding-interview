package answerFromBook.ch2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class LinkedList implements Palindrome {

    private static final Logger logger = LogManager.getLogger(LinkedList.class);

    Node head;

    public char getNth(int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index)
                return current.data;
            count++;
            current = current.next;
        }

        assert (false);
        return '\u0000';
    }

    public Node getNthNode (int index) {
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

    public Node getTail() {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public int getLength() {
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
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

    public void appendToTail(char new_data) {

        //Head won't be changed

        if (head == null) {
            head = new Node(new_data);
            return;
        }
        
        Node end = new Node(new_data);
        while (head.next != null) {
            head = head.next;
        }
        head.next = end;
    }

    public void appendToHead(char new_data) {

        //head is changed

        Node newHead = new Node(new_data);
        newHead.next = head;
        head = newHead;

    }

    public List<String> toDeepString() {
        List<String> list = new ArrayList<>();
        Node n = head;
        list.add(n.convertDataToString());
        while (n.next != null) {
            list.add(n.next.convertDataToString());
            n = n.next;
        }
        return list;
    }

    public boolean isPalindrome() {
        return Palindrome.super.isPalindrome(head);
    }
}
