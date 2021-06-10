package com.fqyuan.leetcode.tree;

public class PopulateNext {
    /**
     * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        Node pre = root;
        // from level 0 to level n-2
        while (pre != null) {
            Node cur = pre;
            while (cur != null && cur.left != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next == null ? null : cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }
        return root;
    }

    private void dfs(Node root, Node node) {
        if (root == null) {
            return;
        }
        root.next = node;
        dfs(root.left, root.right);
        dfs(root.right, root.next == null ? null : root.next.left);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
