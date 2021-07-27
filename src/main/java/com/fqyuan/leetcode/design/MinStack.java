package com.fqyuan.leetcode.design;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack1, stack2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        stack1.push(val);
        while (!stack2.isEmpty() && stack2.peek() >= val) {
            stack2.pop();
        }
        stack2.push(val);
    }

    public void pop() {
        if (stack1.peek().equals(stack2.peek())) {
            stack2.pop();
        }
        stack1.pop();
    }

    public int top() {
        return stack1.isEmpty() ? -1 : stack1.peek();
    }

    public int getMin() {
        return stack2.isEmpty() ? -1 : stack2.peek();
    }
}
