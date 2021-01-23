package com.fqyuan.leetcode.list;

public class RemoveLinkedListEle {
    /**
     * https://leetcode.com/problems/remove-linked-list-elements/
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode pre = dum;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                ListNode tmp = cur.next;
                pre.next = tmp;
                cur = tmp;
                continue;
            }
            pre = cur;
            cur = cur.next;
        }

        return dum.next;
    }
}
