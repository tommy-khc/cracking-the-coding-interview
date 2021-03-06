package ch2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PartitionTest {

    @Test
    public void questionOne() {
        Partition.LinkedList list = new Partition.LinkedList();
        int[] elements = {3,5,8,5,10,2,1};
        for (int i : elements) {
            list.appendToTail(i);
        }
        Partition.answer(5, list);

        Partition.LinkedList expected = new Partition.LinkedList();
        expected.appendToTail(3);
        expected.appendToTail(2);
        expected.appendToTail(1);
        expected.appendToTail(5);
        expected.appendToTail(8);
        expected.appendToTail(5);
        expected.appendToTail(10);

        Assertions.assertEquals(expected.toDeepString(), list.toDeepString());
    }

    @Test
    public void verifyHead() {
        Partition.LinkedList list = new Partition.LinkedList();
        System.out.println(list.head);
        int[] elements = {3,5,8,5,10,2,1};
        for (int i : elements) {
            list.appendToTail(i);
        }
        System.out.println(list.head.toString());
        list.GetNth(3);
        System.out.println(list.head.toString());
        System.out.println(list.GetNth(0));
    }
}
