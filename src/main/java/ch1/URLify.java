package ch1;

public class URLify {

    public static String answer (String str) {

        if (str == null) {
            return null;
        }

        char[] cArr = str.toCharArray();

        char[] additionalCharArr = new char[cArr.length];

        int i = 0;
        for (int j = 0 ; j < cArr.length ; j++) {
            if (i == cArr.length) {
                break;
            }else if (!Character.isWhitespace(cArr[j])) {
                additionalCharArr[i++] = cArr[j];
            } else {
                additionalCharArr[i++] = '\u0025';
                additionalCharArr[i++] = '\u0032';
                additionalCharArr[i++] = '\u0030';
            }
        }

        return new String(additionalCharArr);

    }

}
