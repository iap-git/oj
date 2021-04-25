package com.fqyuan.leetcode.string;

import java.util.*;

/**
 * @author fqyua
 * @since 2021/04/25
 */
public class GroupAnagrams {
    /**
     * https://leetcode.com/problems/group-anagrams/
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmpStr = String.valueOf(chars);
            if (!map.containsKey(tmpStr)) {
                map.put(tmpStr, new ArrayList<>());
            }
            map.get(tmpStr).add(str);
        }
        result.addAll(map.values());
        return result;
    }
}
