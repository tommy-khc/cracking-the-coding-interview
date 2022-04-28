package ch1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        int[][] expectedMatrix = {{3,6,9},{2,5,8},{1,4,7}};
        Boolean result = Arrays.deepEquals(expectedMatrix, RotateMatrix.answer(matrix,"90")); // Arrays.deepEquals works at multidimensional array. Besides, Arrays.equals can not
        Assertions.assertEquals(Boolean.TRUE, result);
    }

    //4x4 matrix
    @Test
    public void matrix4X4() {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] expectedMatrix = {{4,8,12,16},{3,7,11,15},{2,6,10,14},{1,5,9,13}};
        Boolean result = Arrays.deepEquals(expectedMatrix, RotateMatrix.answer(matrix,"90"));
        Assertions.assertEquals(Boolean.TRUE, result);
    }

    //4x4 matrix
    @Test
    public void matrix4X4LeeCode() {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] expectedMatrix = {{11,10,7,16},{9,8,6,12},{1,4,3,14},{5,2,13,15}};
        Boolean result = Arrays.deepEquals(expectedMatrix, RotateMatrix.answer(matrix,"90"));
        Assertions.assertEquals(Boolean.TRUE, result);
    }
}
