package com.fqyuan.leetcode.divide_conquer;

/**
 * @author fqyuan
 */
public class Search2Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int row = 0, col = width - 1;
        while (row < height && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    /**
     * binary search and iterative way.
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int[] arr : matrix) {
            if (hasTarget(arr, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasTarget(int[] arr, int target) {
        if (arr == null) {
            return false;
        }
        int start = 0;
        int end = arr.length;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
