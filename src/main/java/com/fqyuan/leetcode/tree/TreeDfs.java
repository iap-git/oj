package com.fqyuan.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** @author fqyuan */
public class TreeDfs {
  public void preDfs(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    list.add(root.val);
    preDfs(root.left, list);
    preDfs(root.right, list);
  }

  public void bfs(TreeNode root) {
    if (root == null) {
        return;
    }
    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    int depth = 0;
    while(!queue.isEmpty()){
        int size = queue.size();
        for(int i=0; i<size; i++){
            TreeNode node = queue.poll();
            result.add(node.val);
            // If ...
            if(node.left !=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        depth++;
    }
  }
}
