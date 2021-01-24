package com.fqyuan.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fqyuan
 */
public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sCh = s.charAt(i);
            Character tCh = t.charAt(i);
            if (!s2t.containsKey(sCh) && !t2s.containsKey(tCh)) {
                s2t.put(sCh, tCh);
                t2s.put(tCh, sCh);
            } else {
                if (s2t.containsKey(sCh) && !s2t.get(sCh).equals(tCh)
                        || t2s.containsKey(tCh) && !t2s.get(tCh).equals(sCh)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIsomorphicArr(String s, String t) {
        char[] inS = s.toCharArray();
        char[] inT = t.toCharArray();

        char[] sArr = new char[256];
        char[] tArr = new char[256];

        for (int i = 0; i < s.length(); i++) {
            char sCh = inS[i];
            char tCh = inT[i];
            if (sArr[sCh] == 0 && tArr[tCh] == 0) {
                sArr[sCh] = tCh;
                tArr[tCh] = sCh;
            } else {
                if (sArr[sCh] != tCh || tArr[tCh] != sCh) {
                    return false;
                }
            }
        }
        return true;
    }
}
