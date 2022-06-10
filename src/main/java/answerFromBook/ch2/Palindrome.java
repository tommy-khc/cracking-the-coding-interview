package answerFromBook.ch2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Stack;

public interface Palindrome {

    Logger logger = LogManager.getLogger(Palindrome.class);

    //Reverse and Compare
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

//    //Iterative approach
//    default boolean isPalindrome (Node head) {
//        Node fast = head;
//        Node slow = head;
//
//        Stack<Character> stack = new Stack<Character>();
//
//        //Push elements from first half of linked list onto stack. When fast runner
//        //(which is moving at 2x speed) reaches the end of the linked list, then we
//        //know we're at the middle
//        while (fast != null && fast.next != null) {
//            stack.push(slow.data);
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        //Has odd number of elements, so skip the middle element
//        if (fast != null) {
//            slow = slow.next;
//        }
//
//        while (slow != null) {
//            char top = stack.pop();
//
//            //if values are different, then it's not a palindrome
//            if (top != slow.data) {
//                return false;
//            }
//            slow = slow.next;
//        }
//        return true;
//    }
}
