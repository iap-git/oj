package com.fqyuan.leetcode.arrays;

/**
 * @author fqyuan
 */
public class RotateImg {
    /**
     * first reverse top and bottom, then swap syt
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int start = 0, end = matrix.length - 1;
        while (start < end) {
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;
            end--;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
