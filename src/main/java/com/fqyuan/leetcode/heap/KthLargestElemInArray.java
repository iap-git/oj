package com.fqyuan.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author fqyuan
 * @date 2021/01/07
 */
public class KthLargestElemInArray {
  /**
   * https://leetcode.com/problems/kth-largest-element-in-an-array/
   *
   * <p>Input: [3,2,1,5,6,4] and k = 2 Output: 5
   *
   * @param nums
   * @param k
   * @return
   */
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int item : nums) {
      queue.offer(item);
    }
    int i = 0;
    int result = 0;
    while (i < k-1) {
      queue.poll();
      i++;
    }
    result = queue.poll();
    return result;
  }
}
