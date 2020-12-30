package com.fqyuan.leetcode.tree;

/**
 * @author fqyuan
 *     <p>https://leetcode.com/problems/invert-binary-tree/submissions/
 */
public class InvertTree {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode lChild = root.left;
    TreeNode rChild = root.right;
    root.left = invertTree(rChild);
    root.right = invertTree(lChild);
    return root;
  }
}
