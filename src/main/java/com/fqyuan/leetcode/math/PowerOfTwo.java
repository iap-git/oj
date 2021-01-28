package com.fqyuan.leetcode.math;

public class PowerOfTwo {
    /**
     * https://leetcode.com/problems/power-of-two/submissions/
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
