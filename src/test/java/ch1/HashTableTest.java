package ch1;

import org.junit.jupiter.api.Test;

public class HashTableTest {

    @Test
    public void put () {
        HashTable h = new HashTable();
        h.put("key1", "shy");
        System.out.println(h.getLinkedLists().toString());
    }

    @Test
    public void get() {
        HashTable h = new HashTable();
        h.put("key1", "shy");
        h.put("key2", "clam");
        h.put("key3", "clever");
        System.out.println(h.get("key3"));
    }
}
