package com.fqyuan.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentEle {

    /**
     * https://leetcode.com/problems/top-k-frequent-elements/
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : nums) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        priorityQueue.addAll(map.entrySet());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll().getKey();
        }
        return result;
    }
}
