package ch1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OneAwayTest {

    //remove
    @Test
    public void questionOne () {
        String str1 = "pale";
        String str2 = "ple";
        Assertions.assertEquals(Boolean.TRUE, OneAway.answer(str1, str2));
    }

    //insert
    @Test
    public void questionTwo () {
        String str1 = "pales";
        String str2 = "pale";
        Assertions.assertEquals(Boolean.TRUE, OneAway.answer(str1, str2));
    }

    //replace
    @Test
    public void questionThree () {
        String str1 = "pale";
        String str2 = "bale";
        Assertions.assertEquals(Boolean.TRUE, OneAway.answer(str1, str2));
    }

    //edited twice
    @Test
    public void questionFour () {
        String str1 = "pale";
        String str2 = "bake";
        Assertions.assertEquals(Boolean.FALSE, OneAway.answer(str1, str2));
    }

    //questionOne
    @Test
    public void questionFive () {
        String str1 = "ple";
        String str2 = "pale";
        Assertions.assertEquals(Boolean.TRUE, OneAway.answer(str1, str2));
    }


    //questionThree
    @Test
    public void questionSix () {
        String str1 = "bale";
        String str2 = "pale";
        Assertions.assertEquals(Boolean.TRUE, OneAway.answer(str1, str2));
    }

    @Test
    public void questionSeven () {
        String str1 = "dfdsfsdfsdfdsfyujkui";
        String str2 = "dfdsfsdfsdfdsfeujkui";
        Assertions.assertEquals(Boolean.TRUE, OneAway.answer(str1, str2));
    }

    //diff words
    @Test
    public void questionEight () {
        String str1 = "dfdsfsdffyujkui";
        String str2 = "dfdsfsdfsdfdsfeujkui";
        Assertions.assertEquals(Boolean.FALSE, OneAway.answer(str1, str2));
    }

    @Test
    public void questionNine () {
        String str1 = "dfdsfsdfsdfdsfyazkui";
        String str2 = "dfdsfsdfsdfdsfeujkui";
        Assertions.assertEquals(Boolean.FALSE, OneAway.answer(str1, str2));
    }
}
