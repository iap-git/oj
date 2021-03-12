package com.fqyuan.leetcode.heap;

import java.util.PriorityQueue;

public class KthCloset {
    /**
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue =
                new PriorityQueue<>(
                        (o1, o2) -> o2[0] * o2[0] + o2[1] * o2[1] - o1[0] * o1[0] - o1[1] * o1[1]);
        for (int[] point : points) {
            if (queue.size() < k) {
                queue.offer(point);
            } else if (queue.size() == k) {
                queue.offer(point);
                queue.poll();
            }
        }
        int[][] result = new int[k][2];
        while (k > 0) {
            result[--k] = queue.poll();
        }
        return result;
    }
}
