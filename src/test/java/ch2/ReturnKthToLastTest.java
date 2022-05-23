package ch2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class ReturnKthToLastTest {
    
    @Test
    public void questionOne() {
        LinkedList list = new LinkedList();
        list.add("1th");
        list.add("2th");
        list.add("3th");
        list.add("4th");
        list.add("5th");
        list.add("6th");
        
        LinkedList expectedList = new LinkedList();
        expectedList.add("4th");
        expectedList.add("5th");
        expectedList.add("6th");

        Assertions.assertEquals(expectedList, ReturnKthToLast.answer(4, list));
    }

    @Test
    public void questionTwo() {
        LinkedList list = new LinkedList();
        list.add("1th");
        list.add("2th");
        list.add("3th");
        list.add("4th");
        list.add("5th");
        list.add("6th");

        LinkedList expectedList = list;

        for (int k = 0 ; k > -10 ; k--) {
            Assertions.assertEquals(expectedList, ReturnKthToLast.answer(0, list));
        }
    }

    @Test
    public void questionThree() {
        LinkedList list = new LinkedList();
        list.add("1th");
        list.add("2th");
        list.add("3th");
        list.add("4th");
        list.add("5th");
        list.add("6th");

        LinkedList expectedList = list;

        for (int k = 7 ; k < 21 ; k++) {
            Assertions.assertEquals(expectedList, ReturnKthToLast.answer(k, list));
        }
    }

    @Test
    public void questionFour() {
        LinkedList list = new LinkedList();
        list.add("1th");
        list.add("2th");
        list.add("3th");
        list.add(null);
        list.add(null);
        list.add(null);

        LinkedList expectedList = new LinkedList();
        expectedList.add(null);
        expectedList.add(null);
        expectedList.add(null);

        Assertions.assertEquals(expectedList, ReturnKthToLast.answer(4, list));
    }

    @Test
    public void answeredbyMethodOne () {
        ch2.LinkedList list = new ch2.LinkedList();
        list.appendToTail('1');
        list.appendToTail('2');
        list.appendToTail('3');
        list.appendToTail('4');
        list.appendToTail('5');
        list.appendToTail('6');

        ReturnKthToLast.methodTwo(list.head, 2);
    }
}
