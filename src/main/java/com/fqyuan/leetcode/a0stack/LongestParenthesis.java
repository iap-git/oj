package com.fqyuan.leetcode.a0stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestParenthesis {
    /**
     * Input: s = ")()())" Output: 4
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }
}
