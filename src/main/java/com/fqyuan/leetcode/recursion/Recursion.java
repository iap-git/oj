package com.fqyuan.leetcode.recursion;

import com.fqyuan.leetcode.tree.TreeNode;
import org.junit.Test;

import java.util.List;

/**
 * 功能描述
 *
 * <p>1. 定义函数，明确功能
 *
 * <p>2. 明确问题和子问题之间的关系（递推公式）
 *
 * <p>3. 递推公式用1中的函数实现
 *
 * <p>4. 通过memo等方式优化复杂度
 *
 * @author y00452957
 * @since 2020-09-23
 */
public class Recursion {

    /**
     * 每次一步或2步，一共有多少种爬法
     *
     * @param n 台阶数
     * @return 爬楼梯方法
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 优化方案，使用mem记录历史计算出的结果，避免重复计算
     *
     * @param n 输入台阶数
     * @return 总方法
     */
    public int climbStairs1(int n) {
        int[] mem = new int[n + 1];
        return clim(n, mem);
    }

    private int clim(int n, int[] mem) {
        if (n <= 2) {
            return n;
        }
        if (mem[n] > 0) {
            return mem[n];
        }
        mem[n] = clim(n - 1, mem) + clim(n - 2, mem);
        return mem[n];
    }

    /**
     * 递归实现sum
     *
     * @param arr
     * @param n
     * @return
     */
    public int sum(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return sum(arr, n - 1) + arr[n - 1];
    }

    /**
     * 二叉树遍历问题
     *
     * @param root
     * @param list
     */
    public void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }


    @Test
    public void test1() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(sum(arr, 5));
    }
}
