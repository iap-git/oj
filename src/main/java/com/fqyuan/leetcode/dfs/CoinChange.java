package com.fqyuan.leetcode.dfs;

/**
 * @author fqyuan
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int temp = coinChange(coins, amount - coins[i]);
            if (temp < result && temp >= 0) {
                result = temp + 1;
            }
        }
        return result;
    }

    public int coinChange(int[] coins, int amount, int[] mem) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (mem[amount - 1] != 0) {
            return mem[amount - 1];
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int tmp = coinChange(coins, amount - coins[i], mem);
            if (tmp < result && tmp >= 0) {
                result = tmp + 1;

            }
        }
        mem[amount - 1] = (result == Integer.MAX_VALUE) ? -1 : result;
        return mem[amount - 1];

    }
}
