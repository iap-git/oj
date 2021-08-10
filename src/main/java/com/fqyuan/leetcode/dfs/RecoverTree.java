package com.fqyuan.leetcode.dfs;

import com.fqyuan.leetcode.tree.TreeNode;

public class RecoverTree {
  private TreeNode firstNode, secondNode;
  private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

  public void recoverTree(TreeNode root) {
    inOrder(root);
    int temp = firstNode.val;
    firstNode.val = secondNode.val;
    secondNode.val = temp;
  }

  private void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    if (firstNode == null && prev.val > root.val) {
      firstNode = prev;
    }
    if (firstNode != null && prev.val > root.val) {
      secondNode = root;
    }
    prev = root;
    inOrder(root.right);
  }
}
