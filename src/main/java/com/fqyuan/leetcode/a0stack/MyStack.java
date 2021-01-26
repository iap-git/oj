package com.fqyuan.leetcode.a0stack;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.offer(x);
        } else {
            if (queue1.isEmpty()) {
                queue1.offer(x);
                while (!queue2.isEmpty()) {
                    queue1.offer(queue2.poll());
                }
            } else {
                queue2.offer(x);
                while (!queue1.isEmpty()) {
                    queue2.offer(queue1.poll());
                }
            }
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue1.isEmpty() ? queue2.poll() : queue1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue1.isEmpty() ? queue2.peek() : queue1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
