package ch3;

import java.util.Arrays;

public class ThreeInOne {

    //single stack in an array
    private int size = 3;

    private Object[] objects = new Object[size];

    public ThreeInOne() {
    }

    public Object pop () {
        for (int i = size-1 ; i >= 0; i--) {
            if (objects[i] != null) {
                Object[] clone = objects.clone();
                Object result = clone[i];
                objects[i] = null;
                return result;
            }
        }
        return null; //isEmpty
    }

    public Object peek () {
        for (int i = size-1 ; i >= 0 ; i--) {
            if (objects[i] != null) {
                return objects[i];
            }
        }
        return null; //isEmpty
    }

    public void push (int n) {
        if (isFull()) {
            addArraysSize();
        }
        for (int i = 0 ; i < size; i++) {
            if (objects[i] == null) {
                objects[i] = n;
                break;
            }
        }
    }

    public Boolean isEmpty () {
        for (Object i : objects) {
            if (i != null) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public Boolean isFull () {
        for (Object i : objects) {
            if (i == null) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    //input: ints (array)
    //output: void
    //function: add size to ints (i.e. create an array which has larger size and replace the original one, same data)
    // update int size
    private void addArraysSize () {
        Object[] replace = new Object[size*2];

        for (int i = 0 ; i < size ; i++) {
            replace[i] = objects[i];
        }

        size = replace.length;
        objects = replace;
    }

    @Override
    public String toString() {
        return "ThreeInOne{" +
                "ints=" + Arrays.toString(objects) +
                '}';
    }

    public int getSize() {
        return size;
    }

}
