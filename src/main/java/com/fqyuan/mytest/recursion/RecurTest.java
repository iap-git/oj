package com.fqyuan.mytest.recursion;

import org.junit.Test;

import java.util.Arrays;

public class RecurTest {

  /** 使用递归实现数组倒序； 依次交换以下位置元素的值： 第1个 与 倒数第1个 第2个 与 倒数第2个 第3个 与 倒数第3个 ... */
  public void reverseArray(int[] array, int start, int end) {
    // 依次交换两端位置元素的值
    if (start < end) {
      int temp = array[end];
      array[end] = array[start];
      array[start] = temp;
      reverseArray(array, start + 1, end - 1);
    }
    // 顺序交换完毕，输出数组
    System.out.println(Arrays.toString(array));
  }

  public String reverse(String s) {
    if (s.length() == 0) {
      return "";
    }
    String subStr = s.substring(1);
    String rev = reverse(subStr);
    String result = rev + s.charAt(0);
    return result;
  }

  @Test
  public void test() {
    int[] arr = {1, 2, 3, 4, 5, 6};
    reverseArray(arr, 0, 5);
  }
}
