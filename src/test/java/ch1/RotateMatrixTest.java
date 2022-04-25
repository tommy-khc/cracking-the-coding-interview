package ch1;

import org.junit.jupiter.api.Test;

public class RotateMatrixTest {

    @Test
    public void checkTwoDimArrayLength() {
        int[][] twoDimArray = {{1,2,3}, {1,2,3,4}};
        System.out.println(twoDimArray.length);
        for (int[] array : twoDimArray) {
            System.out.println(array.length);
        }
    }

    @Test
    public void questionOne() {
        int[][] martix = {{1,2,3},{4,5,6},{7,8,9}};
        RotateMatrix.answer(martix, "90");
    }
}
