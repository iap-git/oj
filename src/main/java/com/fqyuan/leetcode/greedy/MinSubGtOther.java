package com.fqyuan.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fqyuan
 */
public class MinSubGtOther {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        int temp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (sum - temp >= temp) {
                temp += nums[i];
                result.add(nums[i]);
            } else {
                return result;
            }
        }
        return result;
    }
}
