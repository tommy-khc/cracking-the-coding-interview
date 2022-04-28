package ch1;

import org.junit.jupiter.api.Assertions;
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
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] answer = {{3,6,9},{2,5,8},{1,4,7}};
        Assertions.assertEquals(answer, RotateMatrix.answer(matrix, "90"));
    }

    //4x4 matrix
    @Test
    public void matrix4X4() {
        int[][] martix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] answer = {{4,8,12,16},{3,7,11,15},{2,6,10,14},{1,5,9,13}};
        Assertions.assertEquals(answer, RotateMatrix.answer(martix, "90"));
    }

    //4x4 matrix
    @Test
    public void matrix4X4LeeCode() {
        int[][] martix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        RotateMatrix.answer(martix, "90");
    }
}
