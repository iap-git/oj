package com.fqyuan.leetcode.twopointer;

public class SearchIndex {
    public int searchInsert(int[] nums, int target) {
        int result = -1;
        int mid = 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
