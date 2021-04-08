package com.fqyuan.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author fqyuan
 */
public class KthSmallest {
    public int kthSmallest0(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(k - 1);
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrder(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inOrder(root.right, list);
        }
    }

    public int kthSmallest(TreeNode root, int k) {

        if (k <= countTree(root.left)) {
            return kthSmallest(root.left, k);
        } else if (k == countTree(root.left) + 1) {
            return root.val;
        } else {
            return kthSmallest(root.right, k);
        }
    }

    private int countTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countTree(root.left) + countTree(root.right);
    }

    void iterInOrder(TreeNode root, List<Integer> list) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) {
            return;
        }
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            list.add(tmp.val);
            TreeNode right = tmp.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
    }
}
