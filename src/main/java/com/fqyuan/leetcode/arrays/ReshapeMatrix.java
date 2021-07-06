package com.fqyuan.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length, col = mat[0].length;
        if (row * col != r * c) {
            return mat;
        }
        List<Integer> list = new ArrayList<>();
        for (int[] rArr : mat) {
            for (int item : rArr) {
                list.add(item);
            }
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int index = i * c + j;
                result[i][j] = list.get(index);
            }
        }
        return result;
    }
}
