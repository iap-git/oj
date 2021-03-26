package com.fqyuan.leetcode.a0stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MakeStrGreat {
    /**
     * Input: s = "leEeetcode" Output: "leetcode"
     *
     * @param s
     * @return
     */
    public String makeGood(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                char topCh = stack.peek();
                if (ch != topCh && Character.toLowerCase(ch) == Character.toLowerCase(topCh)) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}
