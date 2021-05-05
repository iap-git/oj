package com.fqyuan.leetcode.arrays;

import java.util.Random;

/**
 * @author fqyuan
 */
public class ShuffleArray {
    private Random random;
    private int[] nums;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] arr = new int[nums.length];
        System.arraycopy(nums, 0, arr, 0, nums.length);
        for (int j = 1; j < nums.length; j++) {
            int i = random.nextInt(j + 1);
            swap(arr, i, j);
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
