package com.fqyuan.leetcode.weekcontest;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/** @author fqyuan */
public class Solution {
  public int countConsistentStrings(String allowed, String[] words) {
    Set<Character> set = new HashSet<>();
    for (Character ch : allowed.toCharArray()) {
      set.add(ch);
    }
    int count = 0;
    for (String word : words) {
      if (isConsistent(set, word)) {
        count++;
      }
    }
    return count;
  }

  private boolean isConsistent(Set<Character> set, String str) {
    for (Character ch : str.toCharArray()) {
      if (!set.contains(ch)) {
        return false;
      }
    }
    return true;
  }

  public int[] getSumAbsoluteDifferences(int[] nums) {
    int len = nums.length;
    int[] ans = new int[len];
    for (int i = 1; i < len; i++) {
      ans[0] += nums[i] - nums[0];
    }
    for (int i = 1; i < len; i++) {
      ans[i] =
          ans[i - 1] + (nums[i - 1] - nums[i]) * (len - i - 1) + (nums[i] - nums[i - 1]) * (i - 1);
    }
    return ans;
  }

  private int sumCnt(int index, int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i < index) {
        sum += nums[index] - nums[i];
      } else {
        sum += nums[i] - nums[index];
      }
    }
    return sum;
  }

  public static int numberOfMatches(int n) {
    int ans = 0;
    while (n != 1) {
      if ((n & 1) == 1) {
        n = (n - 1) / 2;
        ans += n;
        n++;
      } else {
        n = n / 2;
        ans += n;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(numberOfMatches(7));
    System.out.println(numberOfMatches(14));
  }

  public int minPartitions(String n) {
    int ans = 0;
    for (Character ch : n.toCharArray()) {
      ans = Math.max(ans, (ch - '0'));
    }
    return ans;
  }

  /**
   * Input: stones = [5,3,1,4,2] Output: 6 Explanation: - Alice removes 2 and gets 5 + 3 + 1 + 4 =
   * 13 points. Alice = 13, Bob = 0, stones = [5,3,1,4]. - Bob removes 5 and gets 3 + 1 + 4 = 8
   * points. Alice = 13, Bob = 8, stones = [3,1,4]. - Alice removes 3 and gets 1 + 4 = 5 points.
   * Alice = 18, Bob = 8, stones = [1,4]. - Bob removes 1 and gets 4 points. Alice = 18, Bob = 12,
   * stones = [4]. - Alice removes 4 and gets 0 points. Alice = 18, Bob = 12, stones = []. The score
   * difference is 18 - 12 = 6.
   *
   * @param stones
   * @return
   */
  public int stoneGameVII(int[] stones) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int item : stones) {
      list.add(item);
    }
    int aScore = 0;
    int bScore = 0;
    boolean flag = true;
    while (!list.isEmpty()) {
      if (flag) {
        if (list.peekFirst() > list.peekLast()) {
          list.removeLast();
        } else {
          list.removeFirst();
        }
        aScore += sum(list);
        flag = false;
      } else {
        if (list.peekFirst() > list.peekLast()) {
          list.removeLast();
        } else {
          list.removeFirst();
        }
        bScore += sum(list);
        flag = true;
      }
    }
    return aScore - bScore;
  }

  int sum(List<Integer> list) {
    int ans = 0;
    for (int item : list) {
      ans += item;
    }
    return ans;
  }

  public String reformatNumber(String number) {
    String tmp = number.replace("-","").replace(" ","");
    StringBuilder sb = new StringBuilder();
    while(tmp.length()>0){
      if(tmp.length()>4){
        sb.append(tmp.substring(0,3)).append("-");
        tmp = tmp.substring(3);
      }else if(tmp.length()==4){
        sb.append(tmp.substring(0,2)).append("-");
        tmp = tmp.substring(2);
      }else if(tmp.length()==3){
        sb.append(tmp.substring(0,3));
        tmp = tmp.substring(3);
      }else if(tmp.length() == 2){
        sb.append(tmp.substring(0,2));
        tmp = tmp.substring(2);
      }
    }
    return sb.toString();
  }

  @Test
  public void test1(){
    System.out.println(reformatNumber("1-23-45 6"));
    System.out.println(reformatNumber("123 4-567"));
    System.out.println(reformatNumber("123 4-5678"));
    System.out.println(reformatNumber("12"));
    System.out.println(reformatNumber("--17-5 229 35-39475 "));
  }

}
