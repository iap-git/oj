package com.fqyuan.leetcode.twopointer;

import com.fqyuan.leetcode.list.ListNode;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode dumOdd = new ListNode(-1);
        ListNode dumEven = new ListNode(-1);
        ListNode odd = dumOdd;
        ListNode even = dumEven;

        int index = 1;
        while (head != null) {
            if (index % 2 != 0) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            // avoid cycle
            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
            index++;
        }
        odd.next = dumEven.next;
        return dumOdd.next;
    }
}
