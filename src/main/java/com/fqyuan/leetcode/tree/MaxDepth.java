package com.fqyuan.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    /**
     * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/submissions/
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node tmp = queue.poll();
                for (Node child : tmp.children) {
                    queue.offer(child);
                }
            }
            depth++;
        }
        return depth;
    }
}
