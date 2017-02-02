package RotateImage;

/**
 * Created by whong53 on 2/1/17.
 */
public class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int s = 0, e = matrix[0].length - 1;
            while (s < e) {
                int tmp = matrix[i][s];
                matrix[i][s] = matrix[i][e];
                matrix[i][e] = tmp;
                s++;
                e--;
            }
        }
    }
}
