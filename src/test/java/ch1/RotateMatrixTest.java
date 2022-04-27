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

    //3x3 matrix
    @Test
    public void matrix3X3() {
        int[][] martix = {{1,2,3},{4,5,6},{7,8,9}};
        RotateMatrix.answer(martix, "90");
    }

    //4x4 matrix
    @Test
    public void matrix4X4() {
        int[][] martix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        RotateMatrix.answer(martix, "90");
    }
}
