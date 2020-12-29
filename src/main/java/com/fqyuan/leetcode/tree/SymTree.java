package com.fqyuan.leetcode.tree;

public class SymTree {
  /**
   *  <p> 递归的写法工具类的使用</p>
   * https://leetcode-cn.com/problems/symmetric-tree/
   * @param root
   * @return
   */
  public boolean isSymmetric(TreeNode root) {
        if(root ==null){
            return true;
        }
        return isSymHelper(root.left, root.right);
    }
    private boolean isSymHelper(TreeNode left, TreeNode right){
        if(left == null || right ==null){
            return left==right;
        }
        if(left.val!= right.val){
            return false;
        }
        return isSymHelper(left.left, right.right)&&isSymHelper(left.right, right.left);
    }
}
