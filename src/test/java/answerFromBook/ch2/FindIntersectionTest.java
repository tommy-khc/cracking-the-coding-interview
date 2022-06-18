package answerFromBook.ch2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindIntersectionTest {

    @Test
    public void questionOne() {

        LinkedList list1 = new LinkedList();
        char[] chars = {'a','b','c','d'};
        for (char c : chars) {
            list1.appendToTail(c);
        }

        LinkedList list2 = new LinkedList();
        list2.appendToTail('b');
        list2.getNthNode(0).next = list1.getNthNode(2);

        Assertions.assertEquals(list1.getNthNode(2), list1.findIntersection(list2));
    }
}
