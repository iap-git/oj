package com.fqyuan.leetcode.list;

/**
 * @author fqyuan
 * @date 2020/11/14
 */
public class Solution {

  /**
   * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 <a></a> 设置dummy节点
   *
   * <p>
   *
   * <p>示例：
   *
   * <p>输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
   *
   * @param l1
   * @param l2
   * @return
   */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dum = new ListNode(-1);
    ListNode p = dum;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }
    while (l1 != null) {
      p.next = l1;
      l1 = l1.next;
      p = p.next;
    }
    while (l2 != null) {
      p.next = l2;
      l2 = l2.next;
      p = p.next;
    }

    return dum.next;
  }
}
