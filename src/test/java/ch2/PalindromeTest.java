package ch2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeTest {

    @Test
    public void questionOne() {
        LinkedList list = new LinkedList();
        list.appendToTail('t');
        list.appendToTail('a');
        list.appendToTail('c');
        list.appendToTail('o');
        list.appendToTail('c');
        list.appendToTail('a');
        list.appendToTail('t');

        Assertions.assertEquals(Boolean.TRUE, Palindrome.methodOne(list));
    }

    @Test
    public void questionTwo() {
        LinkedList list = new LinkedList();
        list.appendToTail('t');
        list.appendToTail('a');
        list.appendToTail('c');
        list.appendToTail('o');
        list.appendToTail('c');
        list.appendToTail('a');
        list.appendToTail('t');

        Assertions.assertEquals(Boolean.TRUE, Palindrome.methodTwo(list));
    }
}
