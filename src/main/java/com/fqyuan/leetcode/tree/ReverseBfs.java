package com.fqyuan.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseBfs {
    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode tmp = queue.poll();
                tmpList.add(tmp.val);
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            result.add(0, tmpList);
        }

        return result;
    }

    private void dfs(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (list.size() <= level) {
            list.add(0, new LinkedList<>());
        }
        dfs(list, root.left, level + 1);
        dfs(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }
}
