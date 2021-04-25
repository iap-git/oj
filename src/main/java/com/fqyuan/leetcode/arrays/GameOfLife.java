package com.fqyuan.leetcode.arrays;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] copyBoard = new int[row][col];
        for (int i = 0; i < row; i++) {
            System.arraycopy(board[i], 0, copyBoard[i], 0, col);
        }
        int[] neighbors = {-1, 0, 1};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int liveCnt = 0;
                for (int l = 0; l < 3; l++) {
                    for (int m = 0; m < 3; m++) {
                        if (!(neighbors[l] == 0 && neighbors[m] == 0)) {
                            int r = i + neighbors[l];
                            int c = j + neighbors[m];
                            if ((r >= 0 && r < row) && (c >= 0 && c < col) && copyBoard[r][c] == 1) {
                                liveCnt++;
                            }
                        }
                    }
                }
                if (copyBoard[i][j] == 1 && (liveCnt > 3 || liveCnt < 2)) {
                    board[i][j] = 0;
                }
                if (copyBoard[i][j] == 0 && liveCnt == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
