package com.fqyuan.design.callback;

public class MainDriver {
    public static void main(String[] args) {
        //
        Student student = new Student();
        student.ask("1/0=", new RoomMate());
    }
}
