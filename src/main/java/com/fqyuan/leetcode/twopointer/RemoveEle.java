package com.fqyuan.leetcode.twopointer;

public class RemoveEle {
    public int removeElement(int[] nums, int target) {
        int result = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                nums[j] = nums[i];
                j++;
            }
        }
        return result;
    }
}
