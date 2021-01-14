package com.fqyuan.leetcode.arrays;

import org.junit.Test;

public class TwoSortedSum {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        int[] result = new int[2];
        while (start < end) {
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                result[0] = start + 1;
                result[1] = end + 1;
                break;

            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        for (int item : twoSum(arr, 9)) {
            System.out.print(item + " ");
        }
    }
}
