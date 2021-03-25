package com.fqyuan.leetcode.a0stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fqyuan
 */
public class CrawlerLogFolder {
    /**
     * @param logs
     * @return
     */
    public int minOperations(String[] logs) {
        int depth = 0;
        Deque<String> stack = new ArrayDeque<>();
        for (String str : logs) {
            if ("../".equals(str)) {
                depth = depth > 0 ? --depth : 0;
                if (depth > 0) {
                    depth--;
                    stack.pop();
                }
            } else if ("./".equals(str)) {
            } else {
                depth++;
                stack.push(str);
            }
        }
        return depth;
    }
}
