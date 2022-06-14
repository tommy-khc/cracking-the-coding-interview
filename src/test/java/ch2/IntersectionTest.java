package ch2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntersectionTest {

    // Definition of same Node (by reference, not value) (example: node1 = node2)
    // The pointers of variables node1 and node2 store / "point" to the same memory address
    @Test
    public void draft() {
        LinkedList list1 = new LinkedList();
        list1.appendToTail('a');
        list1.appendToTail('b');
        list1.appendToTail('c');

        LinkedList list2 = new LinkedList();
        list2.appendToTail('b');
        list2.getNthNode(0).next = list1.getNthNode(2); // same Node

        //Check whether they are the same
        System.out.println(list1.getNthNode(2).toString()); //print memory address
        System.out.println(list2.getNthNode(1).toString()); //should be the same if they are same Node
        System.out.println(list2.getNthNode(1).equals(list1.getNthNode(2))); //can check it by .equal
    }

    @Test
    public void questionOne() {
        LinkedList list1 = new LinkedList();
        list1.appendToTail('a');
        list1.appendToTail('b');
        list1.appendToTail('c');
        list1.appendToTail('d');

        LinkedList list2 = new LinkedList();
        list2.appendToTail('b');
        list2.getNthNode(0).next = list1.getNthNode(2);

        Assertions.assertEquals(list1.getNthNode(2), Intersection.answer(list1, list2));
    }
}
