package ch1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class URLifyTest {

    @Test
    public void questionOne () {
        String str = "Mr John Smith    ";
        Assertions.assertEquals("Mr%20John%20Smith", URLify.answer(str));
    }
}
