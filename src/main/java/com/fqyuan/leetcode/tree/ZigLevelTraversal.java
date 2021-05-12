package com.fqyuan.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigLevelTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode node, List<List<Integer>> list, int level) {
        if (node == null) {
            return;
        }
        if (level >= list.size()) {
            List<Integer> tmpList = new LinkedList<>();
            list.add(tmpList);
        }
        if (level % 2 == 0) {
            list.get(level).add(node.val);
        } else {
            list.get(level).add(0, node.val);
        }
        helper(node.left, list, level + 1);
        helper(node.right, list, level + 1);
    }
}
