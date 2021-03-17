package com.fqyuan.leetcode.heap;

import java.util.PriorityQueue;

public class KthSmallestOfMatrix {
    /**
     * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>();
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            priorityQueue.add(new Tuple(0, i, matrix[0][i]));
        }
        for (int j = 0; j < k - 1; j++) {
            Tuple t = priorityQueue.poll();
            if (t.x == n - 1) {
                continue;
            }
            priorityQueue.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return priorityQueue.peek().val;

    }

    class Tuple implements Comparable<Tuple> {
        private int x;
        private int y;
        private int val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }
}
