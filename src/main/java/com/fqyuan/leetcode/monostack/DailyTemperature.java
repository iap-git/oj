package com.fqyuan.leetcode.monostack;

import java.util.Stack;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
