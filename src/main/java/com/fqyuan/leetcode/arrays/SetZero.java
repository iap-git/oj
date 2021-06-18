package com.fqyuan.leetcode.arrays;

public class SetZero {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean row0Flag = false, col0Flag = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                col0Flag = true;
            }
        }
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                row0Flag = true;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            if (col0Flag) {
                matrix[i][0] = 0;
            }
        }
        for (int i = 0; i < col; i++) {
            if (row0Flag) {
                matrix[0][i] = 0;
            }
        }
    }
}
