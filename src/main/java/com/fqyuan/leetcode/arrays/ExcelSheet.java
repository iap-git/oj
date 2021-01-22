package com.fqyuan.leetcode.arrays;

/**
 * @author fqyuan
 */
public class ExcelSheet {
    /**
     * https://leetcode.com/problems/excel-sheet-column-title/
     *
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            result.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }

    public String convert2Title(int n) {
        if (n == 0) {
            return "";
        }
        return convert2Title(n / 26) + (char) ('A' + n % 26);
    }
}
