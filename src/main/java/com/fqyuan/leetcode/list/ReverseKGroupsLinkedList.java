package com.fqyuan.leetcode.list;

public class ReverseKGroupsLinkedList {
  /**
   * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
   *
   * <p>k 是一个正整数，它的值小于或等于链表的长度。
   *
   * <p>如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
   *
   * <p>
   *
   * <p>示例：
   *
   * <p>给你这个链表：1->2->3->4->5
   *
   * <p>当 k = 2 时，应当返回: 2->1->4->3->5
   *
   * <p>当 k = 3 时，应当返回: 3->2->1->4->5
   *
   * @param head
   * @param k
   * @return
   */
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k == 1) {
      return head;
    }
    ListNode dummy = new ListNode(-1);
    ListNode start = dummy;
    dummy.next = head;
    ListNode end = head;
    int count = 0;
    while (end != null) {
      count++;
      if (count % k == 0) {
        start = reversePart(start, end);
        end = start.next;
      } else {
        end = end.next;
      }
    }
    return dummy.next;
  }

  /**
   * 反转start ~ end之间的链表，不包括首尾
   *
   * @param start
   * @param end
   * @return
   */
  private ListNode reversePart(ListNode start, ListNode end) {
    ListNode dummy = new ListNode(-1);
    ListNode pre = dummy;
    dummy.next = start;
    ListNode cur = start.next;
    ListNode first = start.next;
    while (cur != end) {
      ListNode tmp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = tmp;
    }
    dummy.next = pre;
    first.next = end;
    return first;
  }
}
