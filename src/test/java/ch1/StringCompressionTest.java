package ch1;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCompressionTest {

    @Test
    public void quesitonOne () {
        String str = "aabcccccaaa";
        Assertions.assertEquals("a2b1c5a3",StringCompression.answer(str));
    }

    @Test
    public void quesitonTwo () {
        String str = "aabcccccaaad";
        Assertions.assertEquals("a2b1c5a3d1",StringCompression.answer(str));
    }

    @Test
    public void quesitonThree () {
        String str = "abcccccaaad";
        Assertions.assertEquals("a1b1c5a3d1",StringCompression.answer(str));
    }

    @Test
    public void quesitonFour () {
        String str = "aabbbcccccaaa";
        Assertions.assertEquals("a2b3c5a3",StringCompression.answer(str));
    }

    @Test
    public void quesitonFive () {
        String str = "aabbbcaaa";
        Assertions.assertEquals("a2b3c1a3",StringCompression.answer(str));
    }

    @Test
    public void quesitonSix () {
        String str = "abbcccccaaad";
        Assertions.assertEquals("a1b2c5a3d1",StringCompression.answer(str));
    }
}
