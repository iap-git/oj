package com.fqyuan.leetcode.mono_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreater {
    //    https://leetcode.com/problems/next-greater-element-ii/submissions/
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }
}
