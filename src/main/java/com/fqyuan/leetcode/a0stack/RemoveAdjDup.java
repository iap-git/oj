package com.fqyuan.leetcode.a0stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjDup {

    /**
     * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/submissions/
     *
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character ch : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().equals(ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}
