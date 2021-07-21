package com.fqyuan.leetcode.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * Review on July 20th
 *
 * <p>preSum [] = new int[nums.length + 1];
 *
 * <p>Map.put(preSum, map.get(preSum)b+1);
 *
 * <p>map.put(0, 1), map.put(0, -1)
 */
public class SubSumArray {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int key = k == 0 ? k : preSum % k;
            if (map.containsKey(key)) {
                if (i - map.get(key) >= 2) {
                    return true;
                }
                continue;
            }
            map.put(key, i);
        }
        return false;
    }
}
