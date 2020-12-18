package com.fqyuan.leetcode.list;


import org.junit.Test;

public class RemoveDup {
  /**
   * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct
   * numbers from the original list.
   *
   * <p>Return the linked list sorted as well.
   *
   * <p>Example 1:
   *
   * <p>Input: 1->2->3->3->4->4->5 Output: 1->2->5
   *
   * @param head
   * @return
   */
  public ListNode deleteDuplicates2(ListNode head) {
    ListNode dummy = new ListNode(-1);
    ListNode pre = dummy;
    ListNode cur = head;
    dummy.next = head;
    while (cur != null) {
      while (cur.next != null && cur.val == cur.next.val) {
        cur = cur.next;
      }
      if (pre.next == cur) {
        pre = pre.next;
      } else {
        pre.next = cur.next;
      }
      cur = cur.next;
    }
    return dummy.next;
  }

  /**
   * Given a sorted linked list, delete all duplicates such that each element appear only once.
   *
   * <p>Example 1:
   *
   * <p>Input: 1->1->2 Output: 1->2
   *
   * @param head
   * @return
   */
  public ListNode deleteDuplicates1(ListNode head) {
    if(head == null || head.next == null){
      return head;
    }
    ListNode pre = head;
    ListNode cur = head.next;
    while (cur != null) {
      if(pre.val == cur.val){
        pre.next =cur.next;
        cur = cur.next;
      }else{
        pre = pre.next;
        cur = cur.next;
      }
    }
    return head;
  }

  @Test
  public void test() {
    ListNode head= new ListNode(1);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(3);
    ListNode dum = new ListNode(-1);
    dum.next = head;
    while(head!=null){
      System.out.print(head.val +" ");
      head = head.next;
    }
    ListNode node = deleteDuplicates1(dum.next);
    System.out.println();
    while(node !=null){
      System.out.print(node.val +" ");
      node = node.next;
    }
  }
}
