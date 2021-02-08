package com.fqyuan.leetcode.tree;

import java.util.*;

public class AvgLvlBTree {
    /**
     * [2147483647,2147483647,2147483647]
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            list.add(levelList);
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
                levelList.add(tmp.val);
            }
        }
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            double sum = 0;
            for (int j = 0; j < list.get(i).size(); j++) {
                sum += list.get(i).get(j);
            }
            result.add(sum / list.get(i).size());
        }
        return result;
    }

    public List<Double> averageOfLevels1(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            double sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(sum / n);
        }
        return result;
    }
}
