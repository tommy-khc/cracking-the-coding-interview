package ch1;

public class StringRotation {

    public static Boolean answer (String str1, String str2) {
//        if (str1.length() != str2.length()) {
//            return false;
//        }
//
//        String str3 = str1 + str1;
//        if (str3.contains(str2)) { //contains is the same with isSubstring
//            return true;
//        }
//
//        return false;

        return (str1.length() != str2.length()) &&
                (str1+str2).contains(str2);
    }
}
