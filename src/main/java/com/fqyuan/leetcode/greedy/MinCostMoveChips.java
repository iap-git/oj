package com.fqyuan.leetcode.greedy;

/**
 * @author fqyuan
 */
public class MinCostMoveChips {
    /**
     * @param position
     * @return
     */
    public int minCostToMoveChips(int[] position) {
        int oddCnt = 0, evenCnt = 0;
        for (int item : position) {
            if (item % 2 == 0) {
                evenCnt += 1;
            } else {
                oddCnt += 1;
            }
        }
        return Math.min(oddCnt, evenCnt);
    }
}
