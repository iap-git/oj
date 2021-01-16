package com.fqyuan.leetcode.dfs;

/**
 * @author fqyuan
 * @date 2021/01/16
 */
public class NumArray {
    int[] numArray;
    int[][] mem;

    public NumArray(int[] nums) {
        numArray = new int[nums.length];
        mem = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                mem[i][j] = 0;
            }
        }
        System.arraycopy(nums, 0, numArray, 0, nums.length);
    }

    public int sumRange(int i, int j) {
        if (i == j) {
            mem[i][j] = numArray[i];
            return numArray[i];
        }
        if (mem[i][j] != 0) {
            return mem[i][j];
        }
        mem[i][j] = sumRange(i, j - 1) + numArray[j];
        return mem[i][j];
    }
}
