package ch1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class HashTable {

    private ArrayList<LinkedList> linkedLists = new ArrayList<>();

    public HashTable() {
        for (int k : new int[10]) {
            linkedLists.add(null);
        }
    }

    public void put (String key, Object value) {

        if (key == null || value == null) {
            return;
        }

        //initial capacity of arrayList is 10
        int mod = key.hashCode() % 10;

        if (linkedLists.get(mod) == null) {
            linkedLists.set(mod, new LinkedList<>());
        }

        linkedLists.get(mod).add(key);
        linkedLists.get(mod).add(value);

    }

    public Object get (String key) {

        if (key == null) {
            return null;
        }

        for (LinkedList<Object> list : linkedLists) {
            int i = list.indexOf(key);
            if (i != -1) {
                return list.get(i+1);
            }
        }

        return null;
    }

    public ArrayList<LinkedList> getLinkedLists() {
        return linkedLists;
    }
}
