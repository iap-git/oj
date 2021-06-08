package com.fqyuan.leetcode.sort;

/**
 * @author fqyuan
 */
public class QuickSort {

    /**
     * 快速排序算法
     *
     * @param nums
     * @param low
     * @param high
     */
    public void qSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        // 取左边作为基准数
        int i = low, j = high, index = nums[i];
        while (i < j) {
            // find the first less than index
            while (i < j && nums[j] >= index) {
                j--;
            }
            // put arr[j] in arr[i] and move right
            if (i < j) {
                nums[i++] = nums[j];
            }
            // find the first greater than index
            while (i < j && nums[i] <= index) {
                i++;
            }
            // put arr[i] in arr[j] and move left
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        // put index in pivot position
        nums[i] = index;
        qSort(nums, low, i - 1);
        qSort(nums, i + 1, high);
    }
}
