package ch1;


public class IsUnique {

    public static Boolean answer (String str) {

        if (str == null) {
            return null;
        }

        Boolean unique = Boolean.TRUE;

        for (int i = 0 ; i < str.length() ; i++) {
            for (int j = 0 ; j < str.length() ; j++)
                if (i!=j) {
                    if (str.charAt(i) == str.charAt(j)) {
                        unique = Boolean.FALSE;
                        break;
                    }
                }
        }

        return unique;
    }
}
