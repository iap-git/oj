package com.fqyuan.leetcode;

/**
 * @author fqyuan
 * @since 2020/08/01
 */
public class CountPrimes {
  public int countPrimes(int n) {
    int result = 0;
    for (int i = 2; i <= n; i++) {
      if (isPrime(i)) {
        result++;
      }
    }
    return result;
  }

  private boolean isPrime(int number) {
    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
