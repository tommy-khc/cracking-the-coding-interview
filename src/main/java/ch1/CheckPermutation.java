package ch1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CheckPermutation {

    private static final Logger logger = LogManager.getLogger(CheckPermutation.class);

//    public static Boolean answer (String str1, String str2) {
//
//        //convert char[] to List<character>
//
//        if (str1 == null || str2 == null) {
//            return null;
//        }
//
//        char[] cArr1 = str1.toCharArray();
//        char[] cArr2 = str2.toCharArray();
//
//
//
//        for (char c1 : cArr1) {
//            for (char c2 : cArr2) {
//                if (c1 == c2) {
//                    cArr1.
//                }
//            }
//        }
//
//    }

    //use for loop with index
    public static Boolean answer (String str1, String str2) {

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
}
