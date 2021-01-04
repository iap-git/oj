package com.fqyuan.leetcode.tree;

public class SameTree {
  /**
   * https://leetcode.com/problems/same-tree/
   *
   * @param p
   * @param q
   * @return
   */
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null || q == null) {
      return p == q;
    }
    if (p.val != q.val) {
      return false;
    }
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
