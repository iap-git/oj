package com.fqyuan.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBst {
    /**
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int start = 0, end = list.size() - 1;
        while (start <= end) {
            if (list.get(start) + list.get(end) > k) {
                end--;
            } else if (list.get(start) + list.get(end) < k) {
                start++;
            } else {
                return true;
            }
        }
        return false;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
