package ch2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class LoopDetection {

    private static final Logger logger = LogManager.getLogger(LoopDetection.class);

    public static Node answer (LinkedList list) {

        if (list == null) {
            logger.error("list is null");
            return null;
        }

        Node current = list.head;
        List<String> stringList = new ArrayList<>();
        stringList.add(current.toString());
        current = current.next;
        while (current != null) {
            String address = current.toString();
            for (String str : stringList) {
                if (str.equals(address)) {
                    return current;
                }
            }
            stringList.add(address);
            current = current.next;
        }
        logger.info("List doesn't contain loop.");
        return null;
    }
}
