package com.fqyuan.leetcode.search;

public class RangeSearch {

    public int[] searchRange(int[] nums, int target) {
        int startIdx = binarySearch(nums, target, true);
        int endIdx = binarySearch(nums, target, false) - 1;
        if (startIdx <= endIdx
                && endIdx < nums.length - 1
                && nums[startIdx] == target
                && nums[endIdx] == target) {
            return new int[]{startIdx, endIdx};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int target, boolean lower) {
        int start = 0, end = nums.length, ans = nums.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid] || (target <= nums[mid] && lower)) {
                end = mid - 1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
