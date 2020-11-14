package com.fqyuan.mytest;

public class TestCallback {
    public static void main(String[] args){
        Student stu = new Student();
        Teacher teacher = new Teacher(stu);
        teacher.askQuestion();
    }
}
