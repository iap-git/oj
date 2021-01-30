package com.fqyuan.leetcode.tree;

public class MergeTwoBinaryTree {
    /**
     * https://leetcode.com/problems/merge-two-binary-trees/
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode newNode = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return newNode;
    }
}
