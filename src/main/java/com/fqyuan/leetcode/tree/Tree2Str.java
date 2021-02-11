package com.fqyuan.leetcode.tree;

public class Tree2Str {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (left == "" && right == "") {
            return t.val + "";
        }
        if (left == "") {
            return t.val + "()" + "(" + right + ")";
        }
        if (right == "") {
            return t.val + "(" + left + ")";
        }
        return t.val + "(" + left + ")" + "(" + right + ")";
    }
}
