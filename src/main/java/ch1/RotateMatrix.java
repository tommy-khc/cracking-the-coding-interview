package ch1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.RoundingMode;
import java.util.Arrays;

//int[][] --> int[row n][column k in row n]
//Assume the matrix is square matrix
public class RotateMatrix {

    private static final Logger logger = LogManager.getLogger(RotateMatrix.class);

    public static int[][] answer (int[][] matrix, String angle) {

        if (!(angle.equals("90") || angle.equals("-90"))) {
            logger.error("angle is not available");
            return matrix;
        }

        if (matrix == null) {
            logger.error("martix is null");
            return matrix;
        }

        //check whether it is square matrix
        int row = matrix.length;
        logger.debug("row: " + row);
        int[] noOfElements = new int[row];
        for (int i = 0 ; i < row ; i++) {
            noOfElements[i] = matrix[i].length;
        }
        for (int i : noOfElements) {
            if (i != row) {
                logger.error("it is not square matrix");
                return matrix;
            }
        }

        logger.info("input matrix: " + Arrays.deepToString(matrix));

        //rotation
        int size = row;
        int timesRequired = size/2 + 1;
        logger.debug("timesRequired: " + timesRequired);
        int times = 0;
        //anti-clockwise
        if (angle.equals("90")) {
            for (int i = 0 ; i < size ; i++ ) {
                for (int j = 0 ; j < size ; j++) {

                    if (times == timesRequired) {
                        break;
                    }

                    int temp1 = matrix[i][j];
                    int temp2 = matrix[size-1-j][i];
                    int temp3 = matrix[size-1-i][size-1-j];
                    int temp4 = matrix[i][size-1-j];

                    matrix[size-1-j][i] = temp1;
                    matrix[size-1-i][size-1-j] = temp2;
                    matrix[i][size-1-j]= temp3;
                    matrix[i][j] = temp4;

                    times++;
                }
            }
        }

        logger.info("return: " + Arrays.deepToString(matrix));
        return matrix;
    }
}
