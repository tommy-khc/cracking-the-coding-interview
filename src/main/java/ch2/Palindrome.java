package ch2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Palindrome {

    private static final Logger logger = LogManager.getLogger(Palindrome.class);

    //input: linked list
    //output: boolean
    //function: transfer linkedList to String, then call ch1.PalindromePermutation.answer();
    //O(n)
    public static Boolean methodOne (LinkedList list) {

        if (list == null) {
            logger.error("list is null");
            return null;
        }

        logger.info(list.toDeepString());

        String str = "";
        Node current = list.head;
        while (current != null) {
            str = str + current.data;
            current = current.next;
        }

        return ch1.PalindromePermutation.answer(str);
    }

    //O(n^2)
    public static Boolean methodTwo (LinkedList list) {

        if (list == null) {
            logger.error("list is null");
            return null;
        }

        logger.info(list.toDeepString());

        String forward = "";
        for (int i = 0 ; i < list.getLength() ; i++) {
            char c = list.getNth(i);
            forward = forward + c;
        }
        logger.debug("forward: " + forward);

        String backward = "";
        for (int i = list.getLength()-1 ; i >= 0 ; i--) {
            char c = list.getNth(i);
            backward = backward + c;
        }
        logger.debug("backward: " + backward);


        return forward.equals(backward);
    }
}
