package com.fqyuan.leetcode.tree;

public class BuildTreeWithPostAndIn {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    private TreeNode helper(int postEnd, int inStart, int inEnd, int[] inOrder, int[] postOrder) {
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }
        int inIndex = 0;
        TreeNode root = new TreeNode(postOrder[postEnd]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == postOrder[postEnd]) {
                inIndex = i;
            }
        }
        root.left = helper(postEnd - inEnd + inIndex - 1, inStart, inIndex - 1, inOrder, postOrder);
        root.right = helper(postEnd - 1, inIndex + 1, inEnd, inOrder, postOrder);
        return root;
    }
}
