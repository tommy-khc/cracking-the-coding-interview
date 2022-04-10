package ch1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckPermutation {

    private static final Logger logger = LogManager.getLogger(CheckPermutation.class);

    //convert char[] to List<character>
    public static Boolean methodTwo (String str1, String str2) {

        if (str1 == null || str2 == null) {
            return null;
        }

        char[] cArr1 = str1.toCharArray();
        char[] cArr2 = str2.toCharArray();

        List<Character> characters1 = new ArrayList<>();
        List<Character> characters2 = new ArrayList<>();

        for (char c1 : cArr1) {
            characters1.add(c1);
        }

        for (char c2 : cArr2) {
            characters2.add(c2);
        }

        return checkPre(characters1,characters2);
    }

    //use for loop with index
    public static Boolean methodOne(String str1, String str2) {

        if (str1 == null || str2 == null) {
            return null;
        }

        char[] cArr1 = str1.toCharArray();
        char[] cArr2 = str2.toCharArray();

        return checkPre(cArr1, cArr2);
    }


    public static Boolean checkPre (char[] cArr1, char[] cArr2) {

        for (int i = 0 ; i < cArr1.length ; i++) {
            for (int j = 0 ; j < cArr2.length ; j++) {
                if (cArr1[i] == cArr2[j] &&
                        cArr1[i] != '\u0000' && cArr2[j] != '\u0000') {
                    cArr1[i] = '\u0000';
                    cArr2[j] = '\u0000';
                    return checkPre(cArr1, cArr2);
                }
            }
        }

        return Arrays.equals(cArr1, cArr2);
    }

    public static Boolean checkPre (List<Character> cList1, List<Character> cList2) {

        for (Character c1 : cList1) {
            for (Character c2 : cList2) {
                if (c1 == c2) {
                    cList1.remove(c1);
                    cList2.remove(c2);
                    return checkPre(cList1, cList2);
                }
            }
        }

        return cList1.equals(cList2);
    }
}
