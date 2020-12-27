package com.fqyuan.leetcode.weekcontest;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Dec26 {
  /**
   * @param students
   * @param sandwiches
   * @return
   */
  public int countStudents(int[] students, int[] sandwiches) {
    Deque<Integer> stuQueue = new ArrayDeque<>();
    Deque<Integer> sandQueue = new ArrayDeque<>();
    for (int item : students) {
      stuQueue.addLast(item);
    }
    for (int item : sandwiches) {
      sandQueue.addLast(item);
    }
    int result = 0;
    while (!stuQueue.isEmpty()) {
      while (!stuQueue.isEmpty() && stuQueue.peekFirst().equals(sandQueue.peekFirst())) {
        stuQueue.pollFirst();
        sandQueue.pollFirst();
      }
      if(stuQueue.isEmpty()){
          return 0;
      }
      stuQueue.addLast(stuQueue.pollFirst());
      if(stuQueue.isEmpty()){
          return result;
      }
      if(getDiff(stuQueue, sandQueue.peekFirst()) == 0){
          continue;
      }else{
          return getDiff(stuQueue, sandQueue.peekFirst());
      }

    }
    return result;
  }

  private int getDiff(Queue<Integer> queue, int val) {
    for (int item : queue) {
      if (item == val) {
        return 0;
      }
    }
    return queue.size();
  }
  @Test
    public void test(){
      int[] students  = {1,1,1,0,0,1};
      int[] sandwiches = {1,0,0,0,1,1};
      int result = countStudents(students, sandwiches);
    System.out.println(result);
  }
}
