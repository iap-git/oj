package com.fqyuan.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    /**
     * https://leetcode.com/problems/binary-tree-paths/
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        recPaths(root, "", result);
        return result;
    }

    private void recPaths(TreeNode root, String path, List<String> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
        }
        if (root.left != null) {
            recPaths(root.left, path + root.val + "->", result);
        }
        if (root.right != null) {
            recPaths(root.right, path + root.val + "->", result);
        }
    }
}
