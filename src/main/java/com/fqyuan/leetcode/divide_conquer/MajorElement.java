package com.fqyuan.leetcode.divide_conquer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorElement {
    /**
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : nums) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
            if (map.get(item) > nums.length / 2) {
                return item;
            }
        }
        return -1;
    }

    /**
     * Moore voting algorithm
     *
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        int result = 0;
        int count = 0;
        for (int item : nums) {
            if (count == 0) {
                result = item;
            }
            if (item == result) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}
