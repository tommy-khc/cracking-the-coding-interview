package ch2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

public class RemoveDups {

    //input: LinkedList
    //output: LinkedList
    //function: remove duplicates if a temporary buffer is not allowed
    //Data flow: Using runner tech through two for loop

    private static final Logger logger = LogManager.getLogger(RemoveDups.class);

    public static LinkedList answer (LinkedList list) {

        if (list == null) {
            logger.error("answer, input is null");
            return null;
        }

        logger.info("answer, input: " + list.toString());

        for (int i = 0 ; i < list.size() ; i++) {
            for (int j = i + 1 ; j < list.size() ; j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                }
            }
        }

        logger.info("answer, return: " + list.toString());
        return list;
    }
}
