package com.fqyuan.leetcode.heap;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int kTh;

    public KthLargest(int k, int[] nums) {
        kTh = k;
        for (int item : nums) {
            add(item);
        }
    }

    public int add(int val) {
        if (queue.size() < kTh) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}
