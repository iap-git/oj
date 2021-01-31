package com.fqyuan.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBstTree {
    /**
     * https://leetcode.com/problems/increasing-order-search-tree/
     *
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        TreeNode result = new TreeNode(-1);
        TreeNode cur = result;
        inOrder(root, list);
        for (TreeNode node : list) {
            cur.right = node;
            cur = cur.right;
        }
        return result.right;
    }

    private void inOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root);
        root.left = null;
        inOrder(root.right, list);
    }

    public TreeNode incBst(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode result = new TreeNode(-1);
        cur = result;
        inOrder(root);
        return result.right;
    }

    TreeNode cur;

    /**
     * 左孩子置为空，当前节点并作为上一个的右孩子
     *
     * @param node
     */
    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        node.left = null;
        cur.right = node;
        cur = node.right;
        inOrder(node.right);
    }
}
