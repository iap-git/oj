package com.fqyuan.leetcode.list;

/** @author fqyuan */
public class ReverseList {
  /**
   * https://leetcode.com/problems/reverse-linked-list-ii/ Reverse a linked list from position m to
   * n. Do it in one-pass.
   *
   * <p>Note: 1 ≤ m ≤ n ≤ length of list.
   *
   * <p>Example:
   *
   * <p>Input: 1->2->3->4->5->NULL, m = 2, n = 4 Output: 1->4->3->2->5->NULL
   *
   * @param head
   * @param m
   * @param n
   * @return
   */
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode fakeHead = new ListNode(-1);
    fakeHead.next = head;
    ListNode prev = fakeHead;
    ListNode curr = fakeHead.next;
    int i = 1;
    while (i < m) {
      prev = curr;
      curr = curr.next;
      i++;
    }
    ListNode node = prev;
    while (i <= n) {
      ListNode tmp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = tmp;
      i++;
    }
    node.next.next = curr;
    node.next = prev;
    return fakeHead.next;
  }
}
