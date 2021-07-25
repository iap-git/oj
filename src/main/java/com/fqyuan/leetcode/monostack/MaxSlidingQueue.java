package com.fqyuan.leetcode.monostack;

import java.util.PriorityQueue;

public class MaxSlidingQueue {
    /**
     * 最大滑动窗口
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(
                        (o1, o2) -> {
                            if (o1[0] != o2[0]) {
                                return o2[0] - o1[0];
                            } else {
                                return o2[1] - o1[1];
                            }
                        });
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        result[0] = pq.peek()[0];
        for (int i = k; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] < i - k + 1) {
                pq.poll();
            }
            result[i - k + 1] = pq.peek()[0];
        }

        return result;
    }
}
