package com.fqyuan.leetcode.dfs;

public class BreadthTraverse {
  /*
  // Definition for a Node.
  ;
  */

  public Node connect(Node root) {
    Node dum = new Node(-1);
    dum.next = root;
    while (root != null) {
      Node tmp = new Node(-1);
      Node cur = tmp;
      while (root != null) {
        if (root.left != null) {
          cur.next = root.left;
          cur = cur.next;
        }
        if (root.right != null) {
          cur.next = root.right;
          cur = cur.next;
        }
        root = root.next;
      }
      root = tmp.next;
    }
    return dum.next;
  }
}

class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
}
