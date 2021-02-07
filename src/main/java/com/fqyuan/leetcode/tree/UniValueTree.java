package com.fqyuan.leetcode.tree;

public class UniValueTree {
    /**
     * https://leetcode.com/problems/univalued-binary-tree/
     *
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root.left == root.right) {
            return true;
        }
        if (root.left == null) {
            return root.val == root.right.val && isUnivalTree(root.right);
        }
        if (root.right == null) {
            return root.val == root.left.val && isUnivalTree(root.left);
        }
        return root.val == root.left.val
                && root.val == root.right.val
                && isUnivalTree(root.left)
                && isUnivalTree(root.right);
    }

    public boolean isUni(TreeNode root) {
        return me(root, root.val);
    }

    private boolean me(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        return root.val == val && me(root.left, val) && me(root.right, val);
    }
}
