package com.fqyuan.leetcode.design;

public class MinStack1 {
    private Node head;

    /**
     * initialize your data structure here.
     */
    public MinStack1() {

    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.minVal), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.minVal;
    }

    class Node {
        private int val;
        private int minVal;
        private Node next;

        public Node(int val, int minVal, Node next) {
            this.val = val;
            this.minVal = minVal;
            this.next = next;
        }
    }
}


