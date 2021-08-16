package com.fqyuan.leetcode.dfs;

public class BreadthTraverse {
  /*
  // Definition for a Node.
  ;
  */

  public Node1 connect(Node1 root) {
    Node1 dum = new Node1(-1);
    dum.next = root;
    while (root != null) {
      Node1 tmp = new Node1(-1);
      Node1 cur = tmp;
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

class Node1 {
  public int val;
  public Node1 left;
  public Node1 right;
  public Node1 next;

  public Node1() {}

  public Node1(int _val) {
    val = _val;
  }

  public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
}
