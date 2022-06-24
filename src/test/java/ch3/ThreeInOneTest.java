package ch3;

import org.junit.jupiter.api.Test;

public class ThreeInOneTest {

    //single stack in an array
    @Test
    public void testOne () {
        ThreeInOne stack = new ThreeInOne();
        int number = 0;
        for (int i : new int[10]) {
            stack.push(number);
            number++;
        }
        System.out.println(stack.toString());
        for (int i : new int[stack.getSize()]) { //bug, but that is not the point
            System.out.println(stack.pop().toString());
        }
    }
}
