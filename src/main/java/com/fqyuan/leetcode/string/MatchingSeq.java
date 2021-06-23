package com.fqyuan.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class MatchingSeq {

    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (subseq(word, s)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean subseq(String word, String S) {
        int len = word.length();
        int i = 0;
        for (char ch : S.toCharArray()) {
            if (i < len && ch == word.charAt(i)) {
                i++;
            }
        }
        return i == len;
    }

    public int numMatchingSubseq1(String s, String[] words) {
        int n = s.length();
        Set<String> passSet = new HashSet<>();
        Set<String> outSet = new HashSet<>();
        int result = 0;
        for (String word : words) {
            if (passSet.contains(word) || outSet.contains(word)) {
                if (passSet.contains(word)) {
                    result++;
                }
                continue;
            }
            int i = 0, j = 0;
            while (i < word.length() && j < n) {
                if (word.charAt(i) == s.charAt(j++)) {
                    i++;
                }
            }
            if (i == word.length()) {
                result++;
                passSet.add(word);
            } else {
                outSet.add(word);
            }
        }
        return result;
    }
}
