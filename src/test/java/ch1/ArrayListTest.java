package ch1;

import org.junit.jupiter.api.Test;

public class ArrayListTest {

    @Test
    public void add() {
        ArrayList arr = new ArrayList();
        arr.add("string");
        arr.add(567);
        arr.add(868687L);
    }

    @Test
    public void ToString () {
        ArrayList arr = new ArrayList();
        arr.add("string");
        arr.add(567);
        arr.add(868687L);
        System.out.println(arr.toString());
    }

    @Test
    public void test () {
        Object[] o = new Object[10];
        Boolean a = o == null?Boolean.TRUE:Boolean.FALSE;
        System.out.println(a);
    }
}
