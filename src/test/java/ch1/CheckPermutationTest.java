package ch1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckPermutationTest {

    //check what does '\u0000' (Data Type: char) look like
    @Test
    public void trial1 () {
        char b = '\u0000';
        System.out.println('\u0000');
    }

    @Test
    public void questionOne () {
        String str1 = "tommy";
        String str2 = "mytom";
        Assertions.assertEquals(Boolean.TRUE, CheckPermutation.answer(str1, str2));
    }

    @Test
    public void questionTwo () {
        String str1 = "tommy";
        String str2 = "tititndsdkkl";
        Assertions.assertEquals(Boolean.FALSE, CheckPermutation.answer(str1, str2));

    }
}
