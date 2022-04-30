package ch1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ZeroMatrixTest {

    @Test
    public void questionOne() {
        int[][] matrix = {{1,2,3},{4,0,6},{7,8,9}};
        int[][] answer = ZeroMatrix.answer(matrix);
        int[][] expectedAnswer = {{1,0,3},{0,0,0},{7,0,9}};
        Assertions.assertEquals(Arrays.deepToString(expectedAnswer), Arrays.deepToString(answer));
    }
}
