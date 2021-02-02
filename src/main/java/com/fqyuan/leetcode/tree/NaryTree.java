package com.fqyuan.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
            for (int i = tmp.children.size() - 1; i >= 0; i--) {
                if (tmp.children.get(i) != null) {
                    stack.push(tmp.children.get(i));
                }
            }
        }
        return list;
    }
}
