package ch1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ZeroMatrix {

    private static final Logger logger = LogManager.getLogger(ZeroMatrix.class);

    public static int[][] answer (int[][] matrix) {
        logger.info("answer, input matrix: " + Arrays.deepToString(matrix));
        int[][] copy = matrix.clone(); // there is no deep copy in java
        for (int i = 0 ; i < matrix.length ; i++) {
             copy[i] = matrix[i].clone();
        }
        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[i].length ; j++) {
                Boolean isZero = matrix[i][j] == 0 ? Boolean.TRUE : Boolean.FALSE;
                if (isZero) {

                    // Set its entire row to 0
                    int[] zeroRow = new int[matrix[i].length];
                    logger.debug("answer, zeroRow: " + Arrays.toString(zeroRow));
                    copy[i] = zeroRow;
                    logger.debug("answer, copy[i]: " + Arrays.toString(copy[i]));

                    // Set its entire column to 0
                    for (int[] row : copy) {
                        row[j] = 0;
                        logger.debug("answer, copy: " + Arrays.deepToString(copy));
                        logger.debug("answer, matrix: " + Arrays.deepToString(matrix));
                    }
                }

            }
        }
        logger.info("answer, return: " + Arrays.deepToString(copy));
        return copy;
    }
}
