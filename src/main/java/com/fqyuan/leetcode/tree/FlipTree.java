package com.fqyuan.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipTree {
    int i = 0;
    List<Integer> result = new ArrayList<>();
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return dfs(root, voyage)?result: Arrays.asList(-1);
    }

    private boolean dfs(TreeNode node, int[] voyage){
        if(node == null){
            return true;
        }
        if(node.val != voyage[i++]){
            return false;
        }
        if(node.left !=null && node.left.val != voyage[i]){
            result.add(node.val);
            return dfs(node.right, voyage) && dfs(node.left, voyage);
        }
        return dfs(node.left, voyage) && dfs(node.right, voyage);
    }

}
