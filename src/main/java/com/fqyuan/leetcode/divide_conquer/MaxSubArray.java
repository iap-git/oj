package com.fqyuan.leetcode.divide_conquer;

/**
 * @author fqyuan
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int result = dp[0];
        // dp[i] means the maxSubArray ends with nums[i]
        for (int i = 1; i < n; i++) {
            //
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    /**
     * my 100% beat
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int item : nums) {
            if (sum < 0) {
                sum = 0;
            }
            sum += item;
            result = Math.max(result, sum);
        }
        return result;
    }
}
