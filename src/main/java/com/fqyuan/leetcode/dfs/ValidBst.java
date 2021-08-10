package com.fqyuan.leetcode.dfs;

import com.fqyuan.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidBst {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, int minVal, int maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val > maxVal || root.val < minVal) {
            return false;
        }
        return dfs(root.left, minVal, root.val) && dfs(root.right, root.val, maxVal);
    }

    boolean isValidBst(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode tmp = stack.pop();
            if (pre != null && pre.val >= tmp.val) {
                return false;
            }
            pre = tmp;
            root = tmp.right;
        }
        return true;
    }
}
