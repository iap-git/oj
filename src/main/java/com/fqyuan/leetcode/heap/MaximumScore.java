package com.fqyuan.leetcode.heap;

import java.util.PriorityQueue;

public class MaximumScore {
    /**
     * https://leetcode.com/problems/maximum-score-from-removing-stones/
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        priorityQueue.offer(a);
        priorityQueue.offer(b);
        priorityQueue.offer(c);
        int result = 0;
        while (priorityQueue.size() > 1) {
            int tmp1 = priorityQueue.poll();
            int tmp2 = priorityQueue.poll();
            if (tmp1 > 0) {
                priorityQueue.offer(tmp1);
            }
            if (tmp2 > 0) {
                priorityQueue.offer(tmp2);
            }
            result++;
        }
        return result;
    }
}
