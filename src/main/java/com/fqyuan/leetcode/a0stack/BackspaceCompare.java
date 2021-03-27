package com.fqyuan.leetcode.a0stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackspaceCompare {

    /**
     * Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and T become "ac".
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        return actualStr(S).equals(actualStr(T));
    }

    private String actualStr(String str) {
        StringBuilder sb = new StringBuilder("");
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
