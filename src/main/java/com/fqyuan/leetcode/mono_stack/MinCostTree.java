package com.fqyuan.leetcode.mono_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinCostTree {
    /**
     * in fact, i have no idea why this works?
     * https://leetcode-cn.com/problems/minimum-cost-tree-from-leaf-values/solution/wei-shi-yao-dan-diao-di-jian-zhan-de-suan-fa-ke-xi/
     *
     * @param arr
     * @return
     */
    public int mctFromLeafValues(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.MAX_VALUE);
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > stack.peek()) {
                result += stack.pop() * Math.min(stack.peek(), arr[i]);
            }
            stack.push(arr[i]);
        }
        while (stack.size() > 2) {
            result += stack.pop() * stack.peek();
        }
        return result;
    }
}

//    public int mctFromLeafValues(int[] arr) {
//        Stack<Integer> st = new Stack();
//        st.push(Integer.MAX_VALUE);
//        int mct = 0;
//        for (int i = 0; i < arr.length; i++) {
//            while (arr[i] >= st.peek()) {
//                mct += st.pop() * Math.min(st.peek(), arr[i]);
//            }
//            st.push(arr[i]);
//        }
//        while (st.size() > 2) {
//            mct += st.pop() * st.peek();
//        }
//        return mct;
//    }
