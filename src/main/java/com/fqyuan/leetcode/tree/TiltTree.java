package com.fqyuan.leetcode.tree;

/**
 * @author fqyuan
 */
public class TiltTree {
    int result = 0;

    /**
     * https://leetcode.com/problems/binary-tree-tilt/
     *
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        postOrder(root);
        return result;
    }

    /**
     * 1. define a recursion method
     *
     * <p>2. with subtree results, what else do you want to do for current level?
     *
     * <p>3. what value you want to return to upper level?
     *
     * @param root
     * @return
     */
    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        result += Math.abs(left - right);
        return left + right + root.val;
    }
}
