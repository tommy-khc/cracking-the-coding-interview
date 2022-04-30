package ch1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringRotationTest {

    @Test
    public void questionOne () {
        String str1 = "character";
        String str2 = "acterchara";
        Assertions.assertEquals(Boolean.TRUE, StringRotation.answer(str1, str2));
    }

    @Test
    public void questionTwo () {
        String str1 = "character";
        String str2 = "charaterc";
        Assertions.assertEquals(Boolean.FALSE, StringRotation.answer(str1, str2));
    }
}
