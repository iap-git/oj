package com.fqyuan.leetcode.tree;

import java.util.*;

public class NaryTree {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root != null) {
            list.add(root.val);
            for (Node node : root.children) {
                preorder(node);
            }
        }
        return list;
    }

    public List<Integer> postorder(Node root) {
        if (root != null) {
            for (Node node : root.children) {
                postorder(node);
            }
            list.add(root.val);
        }
        return list;
    }

    public List<Integer> post(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            list.add(tmp.val);
            // center->right->left
            for (Node node : tmp.children) {
                stack.push(node);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> pre(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            list.add(tmp.val);
            // center->left->right;
            for (int i = tmp.children.size() - 1; i >= 0; i--) {
                if (tmp.children.get(i) != null) {
                    stack.push(tmp.children.get(i));
                }
            }
        }
        return list;
    }
}
