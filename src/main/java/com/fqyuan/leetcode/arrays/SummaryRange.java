package com.fqyuan.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {

    /**
     * https://leetcode.com/problems/summary-ranges/
     *
     * <p>双指针思路
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
                end++;
            }
            StringBuilder sb = new StringBuilder();
            if (start == end) {
                sb.append(nums[start]);
            } else {
                sb.append(nums[start] + "->" + nums[end]);
            }
            end++;
            start = end;
            result.add(sb.toString());
        }
        return result;
    }

    public List<String> summaryRanges1(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (nums[i] != tmp) {
                result.add(tmp + "->" + nums[i]);
            } else {
                result.add(tmp + "");
            }
        }
        return result;
    }
}
