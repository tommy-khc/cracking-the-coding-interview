package answerFromBook.ch2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Palindrome {

    Logger logger = LogManager.getLogger(Palindrome.class);

    default boolean isPalindrome (Node head) {

        if (head == null) {
            logger.error("head is null");
            return Boolean.FALSE;
        }
        Node reverse = reverseAndClone(head);
        return isEqual(head, reverse);
    }

    private Node reverseAndClone (Node node) {
        Node head = null;
        while (node != null) {
            Node n = new Node(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    private Boolean isEqual (Node one, Node two) {
        while (one != null && two != null) {
            if (one.data != two.data) {
                return Boolean.FALSE;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null; // We don't use Boolean.True because it can make sure the lengths of them
                                            // are the same
    }
}
