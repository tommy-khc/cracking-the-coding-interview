package ch3;

import java.util.Arrays;

public class ThreeInOne {

    //three stacks in an array
    private int size = 9;

    private Object[] arrays = new Object[size];
    
    private int[] first = {0, 2};
    
    private int[] second = {3, 5};
    
    private int[] third = {6, 8};

    private class Interval {
        int i;
        int f;

        public Interval(int i, int f) {
            this.i = i;
            this.f = f;
        }
    }

    public ThreeInOne() {
    }

    public Object pop (String str) {

        Interval interval = getInterval(str);

        for (int j = interval.i ; j >= interval.f; j--) {
            if (arrays[j] != null) {
                Object[] clone = arrays.clone();
                Object result = clone[j];
                arrays[j] = null;
                return result;
            }
        }
        return null; //isEmpty
    }

    public Object peek (String str) {

        Interval interval = getInterval(str);

        for (int i = interval.i ; i >= interval.f; i--) {
            if (arrays[i] != null) {
                return arrays[i];
            }
        }
        return null; //isEmpty
    }

    public void push (int n, String str) {

        Interval interval = getInterval(str);

        if (isFull(interval)) {
            addArraysSize(str);
        }
        for (int i = 0 ; i < size; i++) {
            if (arrays[i] == null) {
                arrays[i] = n;
                break;
            }
        }
    }

    public Boolean isEmpty () {
        for (Object i : arrays) {
            if (i != null) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public Boolean isFull (Interval interval) {
        for (int j = interval.i; j <= interval.f; j++) {
            if (arrays[j] == null) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    //input: ints (array)
    //output: void
    //function: add size to ints (i.e. create an array which has larger size and replace the original one, same data)
    // update int size
    private void addArraysSize (String str) {

        Interval interval = getInterval(str);
        int length = interval.f - interval.i + 1;
        Object[] replace = new Object[size + length];

        //update index
        if (str.equals("first")) {
            int f1 = first[1] + length;
            int s0 = second[0] + length;
            int s1 = second[1] + length;
            int t0 = third[0] + length;
            int t1 = third[1] + length;

            for (int i = first[0] ; i <= first[1] ; i++) {
                replace[i] = arrays[i];
            }

            int j = second[0];
            for (int i = s0 ; i <= t1 ; i++, j++) {
                replace[i] = arrays[j];
            }

            first[1] = f1;
            second[0] = s0;
            second[1] = s1;
            third[0] = t0;
            third[1] = t1;

            } else if (str.equals("second")) {
            int s1 = second[1] += length;
            int t0 = third[0] += length;
            int t1 = third[1] += length;

            for (int i = second[0] ; i <= second[1] ; i++) {
                replace[i] = arrays[i];
            }

            int j = third[0];
            for (int i = t0 ; i <= t1 ; i++, j++) {
                replace[i] = arrays[j];
            }

            second[1] = s1;
            third[0] = t0;
            third[1] = t1;

        } else if (str.equals("third")) {
            int t1 = third[1] += length;

            for (int i = third[0] ; i <= third[1] ; i++) {
                replace[i] = arrays[i];
            }

            third[1] = t1;
        }

        size = replace.length;
        arrays = replace;
    }

    @Override
    public String toString() {
        return "ThreeInOne{" +
                "ints=" + Arrays.toString(arrays) +
                '}';
    }

    public int getSize() {
        return size;
    }

    private Interval getInterval (String str) {

        if (str.equals("first")) {
            return new Interval(first[1],first[2]);
        } else if (str.equals("second")) {
            return new Interval(second[1],second[2]);
        } else if (str.equals("third")) {
            return new Interval(third[1],third[2]);
        }

        return null;
    }

}
