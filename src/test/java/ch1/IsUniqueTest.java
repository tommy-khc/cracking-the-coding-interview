package ch1;

import org.junit.jupiter.api.Test;

public class IsUniqueTest {

    @Test
    public void answer() {
        String str1 = "hjdhfjf";
        System.out.println(IsUnique.answer(str1));
    }

    @Test
    public void answerTwo() {
        String str1 = "abcdefg";
        System.out.println(IsUnique.answer(str1));
    }
}
