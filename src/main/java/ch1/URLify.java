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

//        if (str == null) {
//            return null;
//        }
//
//        char[] cArr = str.toCharArray();
//
//        List<Character> cArrList = new ArrayList<>();
//
//        for (int i = 0 ; i < cArr.length ; i++) {
//            cArrList.add(cArr[i]);
//        }
//
//        List<Character> additionalCharList = new ArrayList<>();
//        for (Character c : cArrList) {
//            //if it is not a whitespace
//            if (!Character.isWhitespace(c)) {
//                additionalCharList.add(c);
//            } else {
//                additionalCharList.add('\u0025');
//                additionalCharList.add('\u0032');
//                additionalCharList.add('\u0030');
//            }
//        }
//
//        char[] additionalCharArr = new char[additionalCharList.size()];
//        for (int i = 0 ; i < additionalCharList.size() ; i++) {
//            additionalCharArr[i] = additionalCharList.get(i);
//        }
//
//        return new String(additionalCharArr);
}
