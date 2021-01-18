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
        List<List<Integer>> reverseList = new ArrayList<>();
        if (root == null) {
            return reverseList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
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
            reverseList.add(new ArrayList<>(tmpList));
            depth++;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = depth; i > 0; i--) {
            result.add(reverseList.get(i));
        }
        return result;
    }
}
