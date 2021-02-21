package com.fqyuan.leetcode.greedy;

public class BalanceStringSplit {
    /**
     * https://leetcode.com/problems/split-a-string-in-balanced-strings/
     *
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        int result = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += s.charAt(i) == 'L' ? 1 : -1;
            if (cnt == 0) {
                result++;
            }
        }
        return result;
    }
}
