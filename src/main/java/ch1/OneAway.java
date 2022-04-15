package ch1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OneAway {

    private static final Logger logger = LogManager.getLogger(OneAway.class);

    public static Boolean answer (String str1, String str2) {

        if (str1 == null) {
            logger.error("str1 is null");
            return null;
        }

        if (str2 == null) {
            logger.error("str2 is null");
            return null;
        }

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        for (int i = 0 ; i < c1.length ; i++) {
            for (int j = 0 ; j < c2.length ; j++) {
                if (c1[i]==c2[j]) {
                    c1[i] = '\u0000';
                    c2[j] = '\u0000';
                }
            }
        }

        logger.info(str1 + ": " + new String(c1) + ", " + str2 + ": " + new String(c2));

        int indexOfC1 = -1;
        int notEmptyNOOfC1 = 0;
        for (int i = 0 ; i < c1.length ; i++) {
            if (c1[i] != '\u0000') {
                notEmptyNOOfC1++;
                indexOfC1 = i;
            }
        }

        int indexOfC2 = -1;
        int notEmptyNOOfC2 = 0;
        for (int i = 0 ; i < c2.length ; i++) {
            if (c2[i] != '\u0000') {
                notEmptyNOOfC2++;
                indexOfC2 = i;
            }
        }

        //insert or remove
        if ((notEmptyNOOfC1 == 0 && notEmptyNOOfC2 == 1)
                 || (notEmptyNOOfC1 == 1 && notEmptyNOOfC2 == 0)) {
            return Boolean.TRUE;
        // replace
        }else if ((notEmptyNOOfC1 == 1 && notEmptyNOOfC2 == 1)
                && (indexOfC1 == indexOfC2)
                && (indexOfC1 != -1 && indexOfC2 != -1)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
