package com.fqyuan.leetcode.list;

/** @author fqyuan */
public class ListNode {
  int val;
    public ListNode next;

  ListNode() {}

    public ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
