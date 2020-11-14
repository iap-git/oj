package com.fqyuan.mytest;

/** @author fqyuan */
public class Student {
  public void resolveQuestion(ICallback callback) {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    callback.tellAnswer(3);
  }
}
