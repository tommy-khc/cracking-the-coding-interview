package ch2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

public class ReturnKthToLast {

    //input: int k
    //output: linkedlist
    //function: return a linkedList that contains kth to last element

    private static final Logger logger = LogManager.getLogger(ReturnKthToLast.class);

    public static LinkedList answer (int k, LinkedList list) {

        if (k <= 0 || k > list.size()) {
            logger.error("invalid input number: number is out of range.");
            return list;
        }

        if (list == null) {
            logger.error("list is null");
            return list;
        }

        logger.info("answer, input: " + k + "th, " + list.toString());

        LinkedList output = new LinkedList();
        for (int j = k-1 ; j < list.size() ; j++) {
            output.add(list.get(j));
        }

        logger.info("answer, output: " + output.toString());
        return output;

    }
}
