package com.fqyuan.leetcode.tree;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PathSum {

  /**
   * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the
   * given sum.
   *
   * <p>Note: A leaf is a node with no children.
   *
   * <p>Example:
   *
   * <p>Given the below binary tree and sum = 22,
   *
   * <p>5 / \ 4 8 / / \ 11 13 4 / \ / \ 7 2 5 1
   *
   * https://leetcode.com/problems/path-sum-ii/
   *
   * @param root
   * @param sum
   * @return
   */
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> result = new ArrayList<>();
      if(root == null){
          return result;
      }
      Deque<Integer> path = new ArrayDeque<>();
      backTrack(root, path, result, sum);
      return result;

  }

  private void backTrack(TreeNode node, Deque<Integer> path, List<List<Integer>>result, int remain){
      if(node == null){
          return;
      }
      path.addLast(node.val);
      remain -= node.val;
      if(remain==0 && node.left==null && node.right==null){
          result.add(new ArrayList<>(path));
      }
      backTrack(node.left, path, result, remain);
      backTrack(node.right, path, result, remain);
      path.removeLast();
  }

}
