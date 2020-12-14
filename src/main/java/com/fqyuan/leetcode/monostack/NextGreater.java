package com.fqyuan.leetcode.monostack;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/** @author fqyuan */
public class NextGreater {

  /**
   * [4,1,2] [1,3,4,2]
   *
   * <p>[-1,3,-1]
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length];
    Map<Integer, Integer> map = new HashMap<>();
    Deque<Integer> stack = new ArrayDeque<>();
    for (int item : nums2) {
      while (!stack.isEmpty() && item > stack.peek()) {
        map.put(stack.pop(), item);
      }
      stack.push(item);
    }
    for (int i = 0; i < nums1.length; i++) {
      result[i] = map.getOrDefault(nums1[i], -1);
    }
    return result;
  }

  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Arrays.fill(result, -1);
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < 2 * n; i++) {
      while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
        int index = stack.pop();
        result[index] = nums[i % n];
      }
      stack.push(i % n);
    }
    return result;
  }
}
