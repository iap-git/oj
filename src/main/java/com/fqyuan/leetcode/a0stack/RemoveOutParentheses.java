package com.fqyuan.leetcode.a0stack;

public class RemoveOutParentheses {
    /**
     * amazing way
     *
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : S.toCharArray()) {
            if (ch == '(' && count++ > 0) {
                sb.append(ch);
            }
            if (ch == ')' && count-- > 1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
