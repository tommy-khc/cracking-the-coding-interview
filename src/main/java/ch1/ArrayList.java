package ch1;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList {

    private static final int INITIAL_SIZE = 10;

    private Object[] objects = new Object[INITIAL_SIZE];

    private int size = 0;


    public ArrayList() {
    }

    public void add (Object o) {

        if (o == null) {
            return;
        }

        if (size < objects.length) {
            objects[size++] = o;
        } else {
            Object[] temp = new Object[objects.length*2];
            for (int i = 0; i < objects.length ; i++) {
                temp[i] = objects[i];
            }
            objects = temp;
            add(o);
        }
        for (Object o1 : objects) {
            System.out.println(o1);
        }
    }

    @Override
    public String toString () {
        objects = trimToSize(objects);

        StringBuilder b = new StringBuilder();
        b.append("{ ");
        for (Iterator<Object> iterator = Arrays.stream(objects).iterator() ; iterator.hasNext();) {
            b.append(iterator.next().toString());
            //*Iterator likes a copy of the target collection
            if (iterator.hasNext()) {
                b.append(", ");
            }
        }
        b.append(" }");
        return b.toString();
    }

    private Object[] trimToSize (Object[] arr) {

        int notNullSize = 0;

        for (Object o : arr) {
            if (o != null) {
                notNullSize++;
            }
        }

        System.out.println(notNullSize);

        Object[] objects = new Object[notNullSize];
        int iterator = 0;

        for (Object o : arr) {
            if (o != null) {
                objects[iterator] = o;
                iterator++;
            }
        }

        return objects;
    }
}
