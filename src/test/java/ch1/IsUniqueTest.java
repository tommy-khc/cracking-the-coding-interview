package ch1;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class IsUniqueTest {

    @Test
    public void notUnique() {
        String str1 = "hjdhfjf";
        Assert.assertEquals(Boolean.FALSE, IsUnique.answer(str1));
    }

    @Test
    public void unique() {
        String str1 = "abcdefg";
        Assert.assertEquals(Boolean.TRUE, IsUnique.answer(str1));
    }
}
