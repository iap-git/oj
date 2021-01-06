package com.fqyuan.leetcode.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SuperUglyNumber {
  /**
   * https://leetcode.com/problems/super-ugly-number/
   *
   * @param n
   * @param primes
   * @return
   */
  public int nthSuperUglyNumber(int n, int[] primes) {
    long ans = 1;
    PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
    Set<Long> set = new HashSet<>();
    priorityQueue.offer(1L);
    int count = 0;

    while (count < n) {
      long val = priorityQueue.peek();
      if (!set.contains(val)) {
        set.add(val);
        ans = priorityQueue.poll();
      } else {
        priorityQueue.poll();
        continue;
      }
      count++;
      for (int prime : primes) {
        priorityQueue.offer(ans * prime);
      }
    }
    return (int)ans;
  }
}
