package com.fqyuan.leetcode.a0stack;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 *
 * <p>Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to
 * reach the top of the floor, and you can either start from the step with index 0, or the step with
 * index 1.
 *
 * <p>Example 1:
 *
 * <p>Input: cost = [10, 15, 20] Output: 15 Explanation: Cheapest is start on cost[1], pay that cost
 * and go to the top. Example 2:
 *
 * <p>Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] Output: 6 Explanation: Cheapest is start on
 * cost[0], and only step on 1s, skipping cost[3].
 */
public class MinCostClimbStairs {
  public int minCostClimbingStairs(int[] cost) {
    int len = cost.length;
    return Math.min(minCost(cost, len - 1), minCost(cost, len - 2));
  }

  /**
   * 到达n的花费，含n
   *
   * @param cost
   * @param n
   * @return
   */
  private int minCost(int[] cost, int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    return cost[n - 1] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
  }

  private int minCost(int[] cost, int n, int[] mem) {
    if (n == 0 || n == 1) {
      mem[n] = n;
      return n;
    }
    if (mem[n] != 0) {
      return mem[n];
    }
    mem[n] = cost[n - 1] + Math.min(minCost(cost, n - 1, mem), minCost(cost, n - 2, mem));
    return mem[n];
  }

  private int minCostItr(int[] cost, int n) {
    if (n == 0 || n == 1) {
      return cost[n];
    }
    int[] mem = new int[cost.length];
    for (int i = 2; i <= n; i++) {
      mem[i] = cost[i] + Math.min(mem[i - 1], mem[i - 2]);
    }
    return mem[n];
  }
}
