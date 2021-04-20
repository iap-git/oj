package com.fqyuan.leetcode.trick;

public class IncTrip {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int item : nums) {
            if (item <= small) {
                small = item;
            } else if (item <= big) {
                big = item;
            } else {
                return true;
            }
        }
        return false;
    }
}
