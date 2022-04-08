package ch1;

//Implement my own version of StringBuilder
public class StringBuilder {

    private static final int INITIAL_SIZE = 3;

    private String[] strings = new String[INITIAL_SIZE];

    private int size = 0;

    private int totalCharNumber = 0;


    public StringBuilder() {
    }

    public void append (String str) {

        if (str == null) {
            return;
        }

        if (size < strings.length) {
            strings[size++] = str;
            char[] c = str.toCharArray();
            totalCharNumber += c.length ;
        } else {
            String[] temp = new String[strings.length*2];
            for (int i = 0 ; i < strings.length ; i++) {
                temp[i] = strings[i];
            }
            strings = temp;
            append(str);
        }
        for (String s : strings) {
            System.out.println(s);
        }
    }

    public String toString () {

        char[] totalChar = new char[totalCharNumber];
        int iteratorIndex = 0;
        for (String str : strings) {
            if (str != null) {
                for (char c : str.toCharArray()) {
                    totalChar[iteratorIndex++] = c;
                }
            }
        }

        return new String(totalChar);
    }

    public String[] getStrings() {
        return strings;
    }
}
