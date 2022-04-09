package ch1;


public class IsUnique {

//    public static Boolean answer (String str) {
//
//        if (str == null) {
//            return null;
//        }
//
//        Char[] cArr = str.toCharArray();
//        Boolean equal = Boolean.FALSE;
//
//        for (Char c1 : cArr) {
//            for (Char c2 : cArr) {
//
//            }
//        }
//    }

    public static Boolean answer (String str) {


        if (str == null) {
            return null;
        }

        Boolean equal = Boolean.TRUE;

        for (int i = 0 ; i < str.length() ; i++) {
            for (int j = 0 ; j < str.length() ; j++)
                if (i!=j) {
                    equal = str.charAt(i) == str.charAt(j) ? Boolean.FALSE : equal;
                }
        }
        return equal;
    }
}
