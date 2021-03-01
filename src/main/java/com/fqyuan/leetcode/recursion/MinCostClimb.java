package com.fqyuan.leetcode.recursion;

/**
 * @author fqyuan 2021/03/01
 */
public class MinCostClimb {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(minCostItr(cost, n - 1), minCostItr(cost, n - 2));
    }

    private int minCostItr(int[] cost, int n) {
        if (n == 0 || n == 1) {
            return cost[n];
        }
        int[] mem = new int[cost.length];
        mem[0] = cost[0];
        mem[1] = cost[1];
        for (int i = 2; i <= n; i++) {
            mem[i] = cost[i] + Math.min(mem[i - 1], mem[i - 2]);
        }
        return mem[n];
    }
}
