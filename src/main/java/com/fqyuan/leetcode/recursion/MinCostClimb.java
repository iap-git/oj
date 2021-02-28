package com.fqyuan.leetcode.recursion;

/**
 * @author fqyuan 2021/03/01
 */
public class MinCostClimb {
    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        return Math.min(minCost1(cost, n - 1), minCost1(cost, n - 2));
    }

    /**
     * recursion
     *
     * @param cost
     * @param n
     * @return
     */
    private int minCost1(int[] cost, int n) {
        if (n == 0 || n == 1) {
            return cost[n];
        }
        return cost[n] + Math.min(minCost1(cost, n - 1), minCost1(cost, n - 2));
    }

    int[] dp;

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        return Math.min(minCost2(cost, n - 1), minCost2(cost, n - 2));
    }

    /**
     * top-down dp
     *
     * @param cost
     * @param n
     * @return
     */
    private int minCost2(int[] cost, int n) {
        if (n == 0 || n == 1) {
            dp[n] = cost[n];
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = cost[n] + Math.min(minCost2(cost, n - 1), minCost2(cost, n - 2));
        return dp[n];
    }

    public int minCostClimbingStairs3(int[] cost) {
        int n = cost.length;
        return Math.min(minCostItr(cost, n - 1), minCostItr(cost, n - 2));
    }

    /**
     * bottom up
     *
     * @param cost
     * @param n
     * @return
     */
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
