package ch1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringCompression {

    private static final Logger logger = LogManager.getLogger(StringCompression.class);

    public static String answer (String str) {

        if (str == null) {
            return null;
        }

        char[] chars = str.toCharArray();

        String compressed = "";
        int repeated = 1;
        char currentCharacter = chars[0];

        for (int i = 1 ; i < chars.length ; i++) {
            if (currentCharacter == chars[i]) {
                repeated++;
            } else {
                compressed += String.valueOf(currentCharacter) + repeated;
                currentCharacter = chars[i];
                repeated = 1;
            }
            if (i == chars.length - 1) {
                compressed += String.valueOf(currentCharacter) + repeated;
            }
        }

        logger.info("return: " + compressed);
        return compressed;
    }
}
