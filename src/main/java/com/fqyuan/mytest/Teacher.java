package com.fqyuan.mytest;

/**
 * @author fqyuan
 * @since 2020/07/29
 */
public class Teacher implements ICallback {
  Student student;

  Teacher(Student stu) {
    student = stu;
  }
  public void askQuestion(){
      student.resolveQuestion(this);
  }
  @Override
  public void tellAnswer(int ans) {
    System.out.println("The answer is " + ans);
  }
}
