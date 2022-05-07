package ch2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class RemoveDupsTest {

    @Test
    public void questionOne() {
        LinkedList list = new LinkedList();
        list.add("String");
        list.add("dfjdsjfhd");
        list.add(879);
        list.add(6788);
        list.add("dfjdsjfhd");
        list.add("String");

        LinkedList expectedAnswer = new LinkedList();
        expectedAnswer.add("String");
        expectedAnswer.add("dfjdsjfhd");
        expectedAnswer.add(879);
        expectedAnswer.add(6788);

        Assertions.assertEquals(expectedAnswer, RemoveDups.answer(list));
    }
}
