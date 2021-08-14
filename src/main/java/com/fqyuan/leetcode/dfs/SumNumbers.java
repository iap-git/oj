package com.fqyuan.leetcode.dfs;

import com.fqyuan.leetcode.tree.TreeNode;

public class SumNumbers {
  public int sumNumbers(TreeNode root) {
    return dfs(root, 0);
  }

  private int dfs(TreeNode root, int curSum) {
    if (root == null) {
      return 0;
    }
    curSum = curSum * 10 + root.val;
    if (root.left == null && root.right == null) {
      return curSum;
    }
    int leftVal = dfs(root.left, curSum);
    int rightVal = dfs(root.right, curSum);
    return leftVal + rightVal;
  }
}
