package ch3;

public class ThreeInOne {

    private int[] ints = new int[3];

    public ThreeInOne() {
    }

    public int pop () {
        for (int i = 0 ; i < 3; i++) {
            if (ints[i] != 0) {
                int result = ints[i];
                ints[i] = 0;
                return result;
            }
        }
        return 0; //isEmpty
    }

    public int peek () {
        for (int i = 0 ; i < 3; i++) {
            if (ints[i] != 0) {
                return ints[i];
            }
        }
        return 0; //isEmpty
    }

    public void push (int n) {
        for (int i = 2 ; i > 0; i--) {
            if (ints[i] == 0) {
                ints[i] = n;
            }
        }
    }

    public boolean isEmpty () {
        for (int i : ints) {
            if (i != 0) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
