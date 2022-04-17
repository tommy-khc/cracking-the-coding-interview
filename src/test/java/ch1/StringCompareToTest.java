package ch1;

import org.junit.jupiter.api.Test;

public class StringCompareToTest {

    @Test
    public void questionOne () {
        String str = "abc";
        String str2 = "bbcd";
        System.out.println(str.compareTo(str2));
    }
}
