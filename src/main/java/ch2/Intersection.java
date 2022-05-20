package ch2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Intersection {

    private static final Logger logger = LogManager.getLogger(Intersection.class);

    public static Boolean answer(LinkedList list1, LinkedList list2) {

        if (list1 == null) {
            logger.error("list1 is null");
            return null;
        }

        if (list2 == null) {
            logger.error("list2 is null");
            return null;
        }

        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null) {
            while (current2 != null) {
                if (current1.equals(current2)) {
                    return Boolean.TRUE;
                }
                current2 = current2.next;
            }
            current2 = list2.head;
            current1 = current1.next;
        }
        return Boolean.FALSE;
    }
}
