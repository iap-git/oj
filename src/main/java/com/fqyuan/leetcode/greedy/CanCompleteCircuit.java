package com.fqyuan.leetcode.greedy;

public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int i = 0;

        while (i < len) {
            int count = 0;
            int sumOfGas = 0;
            int sumOfCost = 0;
            while (count < len) {
                int j = (i + count) % len;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfGas < sumOfCost) {
                    break;
                }
                count++;
            }

            if (count == len) {
                return i;
            } else {
                i = i + count + 1;
            }
        }
        return -1;
    }
}
