package ch1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StringBuilderTest {

    @Test
    public void testOne () {
        String[] input = {"abc", "def", "ghi", "123", "1234"};
        StringBuilder b = new StringBuilder();
        for (String str : input) {
            b.append(str);
        }
        for (String str : b.getStrings()) {
            System.out.println(str);
        }
    }

    @Test
    public void testTwo () {
        String[] input = {"abc", "def", "ghi", "sadsd", "1234"};
        StringBuilder b = new StringBuilder();
        for (String str : input) {
            b.append(str);
        }
        System.out.println(b.toString());
    }
}
