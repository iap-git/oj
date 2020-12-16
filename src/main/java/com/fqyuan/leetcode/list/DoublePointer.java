package com.fqyuan.leetcode.list;

public class DoublePointer {
  /**
   * https://leetcode.com/problems/linked-list-cycle/
   * Given head, the head of a linked list, determine if the linked list has a cycle in it.
   *
   * @param head
   * @return
   */
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }

    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  /**
   * https://leetcode.com/problems/linked-list-cycle-ii/
   * @param head
   * @return
   */
  public ListNode detectCycle(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        ListNode slow2 = head;
        while (slow2 != fast) {
          slow2 = slow2.next;
          fast = fast.next;
        }
        return slow2;
      }
    }
    return null;
  }
}
