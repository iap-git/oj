package com.fqyuan.leetcode.dfs;

import com.fqyuan.leetcode.tree.TreeNode;

import java.util.Arrays;

public class BuildFromInAndPre {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;

        if(preorder.length == 0){
            return root;
        }
        //当前前序遍历的第一个元素
        int rootVal = preorder[0];
        root = new TreeNode(root.val);

        //获取在inorder中序遍历数组中的位置
        int index = 0;
        for(int i = 0; i < inorder.length; i++){
            if(rootVal == inorder[i]){
                index = i;
            }
        }

        //递归去做
        root.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        root.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return root;
    }
}
