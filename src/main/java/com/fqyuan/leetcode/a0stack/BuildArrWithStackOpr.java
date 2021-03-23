package com.fqyuan.leetcode.a0stack;

import java.util.ArrayList;
import java.util.List;

public class BuildArrWithStackOpr {
    /**
     * https://leetcode.com/problems/build-an-array-with-stack-operations/submissions/
     *
     * @param target
     * @param n
     * @return
     */
    public List<String> buildArray(int[] target, int n) {
        int cnt = target.length;
        List<String> result = new ArrayList<>();
        int j = 0;
        for (int i = 1; i <= n && j < cnt; i++) {
            result.add("Push");
            if (target[j] == i) {
                j++;
            } else {
                result.add("Pop");
            }
        }
        return result;
    }
}
