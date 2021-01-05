package com.fqyuan.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/** @author fqyuan */
public class LastStoneWeight {
  /**
   * https://leetcode.com/problems/last-stone-weight/
   *
   * <p>Input: [2,7,4,1,8,1] Output: 1
   *
   * @param stones
   * @return
   */
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int stone : stones) {
      priorityQueue.offer(stone);
    }
    while (priorityQueue.size() > 1) {
      int val1 = priorityQueue.poll();
      int val2 = priorityQueue.poll();
      priorityQueue.offer(val1 - val2);
    }
    return priorityQueue.poll();
  }
}
