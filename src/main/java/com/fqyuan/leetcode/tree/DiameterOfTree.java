package com.fqyuan.leetcode.tree;

public class DiameterOfTree {
  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int dia = depth(root.left) + depth(root.right);
    int lD = diameterOfBinaryTree(root.left);
    int rD = diameterOfBinaryTree(root.right);
    return Math.max(dia, Math.max(lD, rD));
  }

  private int depth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(depth(root.left), depth(root.right)) + 1;
  }

  int result;

  public int dia(TreeNode root) {
      result = 0;
      maxDepth(root);
      return result;
  }

  private int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int l = maxDepth(root.left);
    int r = maxDepth(root.right);
    result = Math.max(result, l + r);
    return Math.max(l, r) + 1;
  }
}
