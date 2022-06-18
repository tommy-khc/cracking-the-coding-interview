package answerFromBook.ch2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class loopDetectableTest {

    @Test
    public void questionOne() {
        LinkedList list = new LinkedList();
        list.appendToTail('a'); //0
        list.appendToTail('b'); //1
        list.appendToTail('c'); //2
        list.appendToTail('d'); //3
        list.appendToTail('e'); //4
        list.appendToTail('f'); //5
        list.appendToTail('g'); //6
        list.getNthNode(6).next = list.getNthNode(2);

        Assertions.assertEquals(list.getNthNode(2), list.searchBeginningOfLoop());
    }
}
