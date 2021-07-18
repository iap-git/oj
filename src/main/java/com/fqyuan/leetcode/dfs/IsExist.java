package com.fqyuan.leetcode.dfs;

/**
 * backtrack
 *
 * @author fqyuan
 * @date 2021/07/18
 */
public class IsExist {
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (isExist(board, y, x, arr, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isExist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) {
            return true;
        }
        if (y < 0 || x < 0 || y == board.length || x == board[0].length) {
            return false;
        }
        if (board[y][x] != word[i]) {
            return false;
        }
        board[y][x] ^= 256;
        boolean existFlag =
                isExist(board, y - 1, x, word, i + 1)
                        || isExist(board, y, x + 1, word, i + 1)
                        || isExist(board, y + 1, x, word, i + 1)
                        || isExist(board, y, x - 1, word, i + 1);
        board[y][x] ^= 256;
        return existFlag;
    }
}

//    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
//        if (i == word.length) return true;
//        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
//        if (board[y][x] != word[i]) return false;
//        board[y][x] ^= 256;
//        boolean exist = exist(board, y, x+1, word, i+1)
//                || exist(board, y, x-1, word, i+1)
//                || exist(board, y+1, x, word, i+1)
//                || exist(board, y-1, x, word, i+1);
//        board[y][x] ^= 256;
//        return exist;
//    }
