package ch1;

import java.util.Arrays;
import java.util.Locale;

public class PalindromePermutation {

    public static Boolean answer (String str) {

        if (str == null) {
            return null;
        }

        str = str.toLowerCase(Locale.ROOT);
        str = str.replaceAll("[^a-z]", "");

        char[] forwards = str.toCharArray();
        char[] backwards = new char[forwards.length];

        int j = 0;
        for (int i = forwards.length-1 ; i >= 0 ; i--) {
            backwards[j++] = forwards[i];
        }

//        for (int i = 0 ; i < backwards.length ; i++) {
//            backwards[i] = forwards[forwards.length-1-i];
//        }

        return Arrays.equals(forwards, backwards);
    }
}
