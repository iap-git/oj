package com.fqyuan.leetcode.dfs;

/**
 * Typical use of dfs
 */
public class NumOfIslands {
    public int numIslands(char[][] grid) {
        int numOfRows = grid.length;
        int numOfCols = grid[0].length;
        int result = 0;
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int row, int col) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (row < 0 || col < 0 || row >= nr || col >= nc || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
