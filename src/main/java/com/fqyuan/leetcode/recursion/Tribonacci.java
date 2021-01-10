package com.fqyuan.leetcode.recursion;

public class Tribonacci {
    /**
     * https://leetcode.com/problems/n-th-tribonacci-number/submissions/
     *
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        int[] mem = new int[n + 1];
        if (n == 0) {
            mem[0] = 0;
            return 0;
        }
        if (n <= 2) {
            mem[n] = 1;
            return 1;
        }
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 1;
        for (int i = 3; i <= n; i++) {
            mem[i] = mem[i - 3] + mem[i - 2] + mem[i - 1];
        }
        return mem[n];
    }
}
