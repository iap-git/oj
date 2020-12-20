package com.fqyuan.leetcode.list;

/** @author fqyuan */
public class Partition {
  public ListNode partition(ListNode head, int x) {
    ListNode dumLeft = new ListNode(-1);
    ListNode dumRight = new ListNode(-1);
    ListNode left = dumLeft, right = dumRight;
    while(head !=null){
        if(head.val<x){
            left.next = head;
            left = head;
        }else{
            right.next = head;
            right = head;
        }
        head = head.next;
    }
    left.next = dumRight.next;
    // Or Cycle will exist
    right.next = null;
    return dumLeft.next;
  }
}
