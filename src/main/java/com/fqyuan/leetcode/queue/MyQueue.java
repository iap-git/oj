package com.fqyuan.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fqyuan
 */
public class MyQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            stack1.push(x);
        } else if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack2.push(x);
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack1.isEmpty() ? stack2.pop() : stack1.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack1.isEmpty() ? stack2.peek() : stack1.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
