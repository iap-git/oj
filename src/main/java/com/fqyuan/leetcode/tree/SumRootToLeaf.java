package com.fqyuan.leetcode.tree;

public class SumRootToLeaf {

    /**
     * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/submissions/
     *
     * @param root
     * @return
     */
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = val * 2 + root.val;
        if (root.left == root.right) {
            return val;
        } else {
            return dfs(root.left, val) + dfs(root.right, val);
        }
    }
}
