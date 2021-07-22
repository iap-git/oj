package com.fqyuan.leetcode.monostack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值
 *
 * <p>若队列为空，pop_front 和 max_value 需要返回 -1
 */
public class MaxQueue {
    Queue<Integer> queue = new LinkedList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    public int maxValue() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void offer(int val) {
        queue.offer(val);
        while (!deque.isEmpty() && val > deque.peekLast()) {
            deque.pollLast();
        }
        deque.offerLast(val);
    }

    public int poll() {
        if (queue.isEmpty()) {
            return -1;
        }
        while (queue.peek().equals(deque.peekFirst())) {
            deque.pollFirst();
        }
        return queue.poll();
    }
}
