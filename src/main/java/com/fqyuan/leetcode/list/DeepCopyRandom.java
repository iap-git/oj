package com.fqyuan.leetcode.list;

public class DeepCopyRandom {
  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }
    // Iter 1:
    Node cur = head;
    while (cur != null) {
      Node tmp = cur.next;
      cur.next = new Node(cur.val);
      cur.next.next = tmp;
      cur = tmp;
    }

    // Iter 2:
    cur = head;
    while (cur != null) {
      if (cur.random != null) {
        cur.next.random = cur.random.next;
      }
      cur = cur.next.next;
    }

    // Iter 3:
    cur = head;
    Node copyHead = head.next;
    Node p = copyHead;
    while (p.next != null) {
      cur.next = cur.next.next;
      cur = cur.next;

      p.next = p.next.next;
      p = p.next;
    }
    cur.next = null;
    return copyHead;
  }
}
