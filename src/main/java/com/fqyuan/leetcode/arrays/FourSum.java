package com.fqyuan.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class FourSum {
    /**
     * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of
     * tuples (i, j, k, l) such that:
     *
     * <p>https://leetcode.com/problems/4sum-ii/
     *
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = nums1[i] + nums2[j];
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = nums3[i] + nums4[j];
                res += map.getOrDefault(-1 * temp, 0);
            }
        }
        return res;
    }
}
