package com.fqyuan.leetcode.greedy;

public class LargestSquareCnt {
    /**
     * https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/
     *
     * @param rectangles
     * @return
     */
    public int countGoodRectangles(int[][] rectangles) {
        int result = 0;
        int maxWidth = 0;
        for (int[] rect : rectangles) {
            int min = Math.min(rect[0], rect[1]);
            if (min > maxWidth) {
                maxWidth = min;
                result = 1;
            } else if (min == maxWidth) {
                result++;
            }
        }
        return result;
    }
}
