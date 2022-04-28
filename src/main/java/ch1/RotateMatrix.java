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
        //initial state: outermost layer in matrix, the first rotated element is matrix[0][0]
        int length = matrix.length; // length of matrix
        int l = matrix.length; //length of layer
        for (int i = 0 ; i <= (length/2)-1 ; i++, l-=2) { // i means matrix[i][i], the first rotated element in each layer
            matrix = rotateElementsInLayer(matrix, i, l, angle);
        }

        logger.info("return: " + Arrays.deepToString(matrix));
        return matrix;
    }

    //i refers to matrix[i][i], first rotated element in each rotation, l means length of the layer
    public static int[][] rotateElementsInLayer (int[][] matrix, int i, int l, String angle) {

        logger.debug("rotateElementsInLayer, input para: " + Arrays.deepToString(matrix) + " " + i + " " + l + " " + angle);

        //last index of matrix[i] or matrix = f
        int f = matrix.length-1;
        double numberOfElements =  l != 2 ? Math.pow(l,2) - Math.pow(l-2,2): 4;
        logger.debug("rotateElementsInLayer, numberOfElements: " + numberOfElements);
        double requiredTimes = numberOfElements/4; //There should not contain any reminders
        logger.debug("requiredTimes: " + requiredTimes);
        double times = 0;

        //anti-clockwise
        if (angle.equals("90")) {
            for (int q = i ; q < l ; q++) {
                for (int p = i ; p < l ; p++) {

                    if (times == requiredTimes) {
                        break;
                    }

                    int temp1 = matrix[q][p];
                    int temp2 = matrix[f-p][q];
                    int temp3 = matrix[f-q][f-p];
                    int temp4 = matrix[p][f-q];

                    matrix[f-p][q] = temp1;
                    matrix[f-q][f-p] = temp2;
                    matrix[p][f-q] = temp3;
                    matrix[q][p] = temp4;

                    times++;
                }
            }
        }

        return matrix;
    }
}
