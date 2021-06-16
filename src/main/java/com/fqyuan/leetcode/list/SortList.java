package com.fqyuan.leetcode.list;

public class SortList {

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode()
     * {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
     * this.next = next; } }
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode l = new ListNode(-1), p = l;
        while (left != null && right != null) {
            if (left.val < right.val) {
                l.next = left;
                left = left.next;
            } else {
                l.next = right;
                right = right.next;
            }
            l = l.next;
        }
        if (left != null) {
            l.next = left;
        }
        if (right != null) {
            l.next = right;
        }
        return p.next;
    }
}
