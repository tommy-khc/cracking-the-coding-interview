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

    @Test
    public void remarkOne() {

        // point to diff address for other objects except array
        int n = 3;
        int k = n;
        n = 7;
        System.out.println(n);
        System.out.println(k);
    }

    @Test
    public void remarkTwo() {

        //point to same address in array
        int[][] n = {{1,2,3} , {4,5,6}};
        int[][] k = n;
        k[0] = new int[]{0, 0, 0};
        System.out.println(Arrays.deepToString(n));
        System.out.println(Arrays.deepToString(k));
    }
}
