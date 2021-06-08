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

    public void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low, j = high, index = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= index) {
                j--;
            }
            while (i < j && arr[i] <= index) {
                i++;
            }
            swap(arr, i, j);
        }
        //set pivot to i
        arr[low] = arr[i];
        arr[i] = index;
        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
  }
}
