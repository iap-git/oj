package com.fqyuan.leetcode.monostack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fqyuan
 * @date 2021/07/29
 */
public class TrapWater {
    public int trap(int[] height) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int cur = stack.peek();
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int right = i;
                int h = Math.min(height[left], height[right]) - height[cur];
                result += h * (right - left - 1);
            }
            stack.push(i);
        }
        return result;
    }
}
