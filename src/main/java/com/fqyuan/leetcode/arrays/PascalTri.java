package com.fqyuan.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTri {
    /**
     * https://leetcode.com/problems/pascals-triangle-ii/submissions/
     *
     * @param k
     * @return
     */
    public List<Integer> getRow(int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k + 1; i++) {
            list.add(1);
            for (int j = i - 1; j > 0; j--) {
                list.set(j, list.get(j - 1) + list.get(j));
            }
        }
        return list;
    }
}
