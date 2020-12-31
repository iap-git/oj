package com.fqyuan.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fqyuan
 *     <p>https://leetcode.com/problems/maximum-width-of-binary-tree/
 */
public class WidthOfTree {
  public int widthOfBinaryTree(TreeNode root) {
    Queue<AnnotatedTree> queue = new LinkedList<>();
    queue.add(new AnnotatedTree(root, 0, 0));
    int left = 0, curDepth = 0, ans = 0;
    while (!queue.isEmpty()) {
      AnnotatedTree cur = queue.poll();
      if (cur.node != null) {
        queue.add(new AnnotatedTree(cur.node.left, cur.depth + 1, 2 * cur.pos));
        queue.add(new AnnotatedTree(cur.node.right, cur.depth + 1, 2 * cur.pos + 1));
        if (curDepth != cur.depth) {
          curDepth = cur.depth;
          left = cur.pos;
        }
        ans = Math.max(ans, cur.pos - left + 1);
      }
    }
    return ans;
  }

  private class AnnotatedTree {
    TreeNode node;
    int depth;
    int pos;

    public AnnotatedTree(TreeNode node, int depth, int pos) {
      this.node = node;
      this.depth = depth;
      this.pos = pos;
    }
  }
}
