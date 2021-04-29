package com.fqyuan.leetcode.a0stack;

import java.util.*;


/**
 * // This is the interface that allows for creating nested lists. // You should not implement it,
 * or speculate about its implementation public interface NestedInteger {
 *
 * <p>// @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 *
 * <p>// @return the single integer that this NestedInteger holds, if it holds a single integer //
 * Return null if this NestedInteger holds a nested list public Integer getInteger();
 *
 * <p>// @return the nested list that this NestedInteger holds, if it holds a nested list // Return
 * empty list if this NestedInteger holds a single integer public List<NestedInteger> getList(); }
 */
public class NestedIterator implements Iterator<Integer> {

    private int cursor;
    private List<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        cursor = 0;
        list = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            flat(nestedInteger);
        }
    }

    @Override
    public Integer next() {
        cursor++;
        return list.get(cursor - 1);
    }

    @Override
    public boolean hasNext() {
        return cursor < list.size();
    }

    private void flat(NestedInteger item) {
        if (item.isInteger()) {
            list.add(item.getInteger());
        } else {
            for (NestedInteger nestedInteger : item.getList()) {
                flat(nestedInteger);
            }
        }
    }
}

class NestedIterator1 implements Iterator<Integer> {
    Deque<NestedInteger> stack = new ArrayDeque<>();

    public NestedIterator1(List<NestedInteger> nestedList) {
        prepare(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) {
                return true;
            }
            prepare(stack.pop().getList());
        }
        return false;
    }

    void prepare(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
    }
}

interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}
