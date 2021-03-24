package com.fqyuan.leetcode.a0stack;

import java.util.LinkedList;

public class BaseBallGameRule {
    /**
     * https://leetcode.com/problems/baseball-game/
     *
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        int result = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (String item : ops) {
            if ("C".equals(item)) {
                result -= list.removeLast();
            } else if ("D".equals(item)) {
                int temp = list.peekLast() * 2;
                list.add(temp);
                result += temp;
            } else if ("+".equals(item)) {
                int temp = list.peekLast() + list.get(list.size() - 2);
                list.add(temp);
                result += temp;
            } else {
                int temp = Integer.parseInt(item);
                list.add(temp);
                result += temp;
            }
        }
        return result;
    }
}
