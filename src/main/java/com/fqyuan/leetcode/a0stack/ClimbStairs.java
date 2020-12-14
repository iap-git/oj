package com.fqyuan.leetcode.a0stack;

/**
 * * You are climbing a staircase. It takes n steps to reach the top. * *
 *
 * <p>Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the *
 * top? * *
 *
 * <p>Example 1: * *
 *
 * <p>Input: n = 2 Output: 2 Explanation: There are two ways to climb to the top. 1. 1 step + 1 *
 * step 2. 2 steps
 */
public class ClimbStairs {
  /**
   * 原始递归方式
   *
   * @param n
   * @return
   */
  public int climbStairs(int n) {
    if (n == 1 || n == 2) {
      return n;
    }
    return climbStairs(n - 1) + climbStairs(n - 2);
  }

  /**
   * Top-down: 带记忆的递归方式，避免重复计算
   *
   * @param n
   * @return
   */
  public int climbStairs1(int n) {
    if (n == 1 || n == 2) {
      return n;
    }
    return climbStairs1(n - 1) + climbStairs1(n - 2);
  }

  private int f(int n, int[] mem) {
    if (n == 1 || n == 2) {
      mem[n] = n;
      return n;
    }
    if (mem[n] != 0) {
      return mem[n];
    }
    mem[n] = f(n - 1, mem) + f(n - 2, mem);
    return mem[n];
  }

  /**
   * Bottom-up: 迭代的方式
   *
   * @param n
   * @return
   */
  public int climbStairs2(int n) {
    if (n == 1 || n == 2) {
      return n;
    }
    int[] mem = new int[n + 1];
    mem[1] = 1;
    mem[2] = 2;
    for (int i = 3; i <= n; i++) {
      mem[i] = mem[i - 1] + mem[i - 2];
    }
    return mem[n];
  }
}
