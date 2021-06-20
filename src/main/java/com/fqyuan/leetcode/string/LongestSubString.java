package com.fqyuan.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Character ch : map.keySet()) {
            int result = 0;
            if (map.get(ch) < k) {
                for (String t : s.split(String.valueOf(ch))) {
                    result = Math.max(longestSubstring(t, k), result);
                }
                return result;
            }
        }
        return s.length();
    }
}
