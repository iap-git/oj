package com.fqyuan.leetcode.tree;

public class NumOfTrees {
  /**
   * g(n) = f(1) + f(2) + ... + f(n)
   *
   * <p>f(i) = g(i-1) * g(n-i)
   *
   * <p>g(n) = g(0)*g(n-1) + g(1)*g(n-2)+...+ g(n-1)*g(0)
   *
   * https://leetcode.com/problems/unique-binary-search-trees/submissions/
   * @param n
   * @return
   */
  public int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] += dp[j - 1] * dp[i - j];
      }
    }
    return dp[n];
  }
}
