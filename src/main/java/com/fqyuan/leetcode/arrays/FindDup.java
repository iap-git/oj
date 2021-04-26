package com.fqyuan.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindDup {
    /**
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int item : nums) {
            if (set.add(item)) {
                return item;
            }
        }
        return -1;
    }

    public int findDuplicate1(int[] nums) {
        while (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
        return -1;
    }
}
