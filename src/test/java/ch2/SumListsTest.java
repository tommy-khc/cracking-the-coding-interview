package ch2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumListsTest {

    //explore before coding SumLists
    @Test
    public void OctalToDecimal() {
        int k = 000;
        System.out.println(k);
    }

    //reverse order
    @Test
    public void questionOne() {
        SumLists.LinkedList list1 = new SumLists.LinkedList();
        list1.appendToTail(7);
        list1.appendToTail(1);
        list1.appendToTail(6);

        SumLists.LinkedList list2 = new SumLists.LinkedList();
        list2.appendToTail(5);
        list2.appendToTail(9);
        list2.appendToTail(2);

        SumLists.LinkedList answer = SumLists.answer(list1,list2, "reverse");

        SumLists.LinkedList expected = new SumLists.LinkedList();
        expected.appendToTail(2);
        expected.appendToTail(1);
        expected.appendToTail(9);

        Assertions.assertEquals(expected.toDeepString(), answer.toDeepString());
    }

    //forward order
    @Test
    public void questionTwo() {
        SumLists.LinkedList list1 = new SumLists.LinkedList();
        list1.appendToTail(6);
        list1.appendToTail(1);
        list1.appendToTail(7);

        SumLists.LinkedList list2 = new SumLists.LinkedList();
        list2.appendToTail(2);
        list2.appendToTail(9);
        list2.appendToTail(5);

        SumLists.LinkedList answer = SumLists.answer(list1,list2, "forward");

        SumLists.LinkedList expected = new SumLists.LinkedList();
        expected.appendToTail(9);
        expected.appendToTail(1);
        expected.appendToTail(2);

        Assertions.assertEquals(expected.toDeepString(), answer.toDeepString());
    }
}
