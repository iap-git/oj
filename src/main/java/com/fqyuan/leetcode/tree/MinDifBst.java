package com.fqyuan.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class MinDifBst {
    /**
     * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            result = Math.min(list.get(i) - list.get(i - 1), result);
        }
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    int result = Integer.MAX_VALUE;
    int pre = result;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return result;
        }
        minDiffInBST(root.left);
        if (pre != Integer.MAX_VALUE) {
            result = Math.min(result, root.val - pre);
        }
        pre = root.val;
        minDiffInBST(root.right);
        return result;
    }
}
