package ch2;

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
        System.out.println(list.toDeepString());
    }

    @Test
    public void questionTwo() {
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
