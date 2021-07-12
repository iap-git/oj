package com.fqyuan.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpirialOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int up = 0, right = col - 1, down = row - 1, left = 0;
        while (result.size() < row * col) {
            for (int i = left; i <= right && result.size() < row * col; i++) {
                result.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down - 1 && result.size() < row * col; i++) {
                result.add(matrix[i][right]);
            }
            for (int i = right; i >= left && result.size() < row * col; i--) {
                result.add(matrix[down][i]);
            }
            for (int i = down - 1; i >= up + 1 && result.size() < row * col; i--) {
                result.add(matrix[i][left]);
            }
            up++;
            right--;
            down--;
            left++;
        }

        return result;
    }
}

/*
   List<Integer> res = new LinkedList<>();
   if (matrix == null || matrix.length == 0) {
       return res;
   }
   int n = matrix.length, m = matrix[0].length;
   int up = 0, down = n - 1;
   int left = 0, right = m - 1;
   while (res.size() < n * m) {
     for (int j = left; j <= right && res.size() < n * m; j++) {
         res.add(matrix[up][j]);
     }

     for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++) {
         res.add(matrix[i][right]);
     }

     for (int j = right; j >= left && res.size() < n * m; j--) {
         res.add(matrix[down][j]);
     }

     for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--) {
         res.add(matrix[i][left]);
     }

     left++;
     right--;
     up++;
     down--;
   }
   return res;
*/
