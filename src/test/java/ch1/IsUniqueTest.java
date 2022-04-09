package ch1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsUniqueTest {

    @Test
    public void notUnique() {
        String str1 = "hjdhfjf";
        Assertions.assertEquals(Boolean.FALSE, IsUnique.answer(str1));
    }

    @Test
    public void unique() {
        String str1 = "abcdefg";
        Assertions.assertEquals(Boolean.TRUE, IsUnique.answer(str1));
    }
}
