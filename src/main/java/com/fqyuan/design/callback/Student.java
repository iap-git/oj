package com.fqyuan.design.callback;

/**
 * @author fqyuan
 */
public class Student implements Callback {
    @Override
    public void doHomeWork(String question, String answer) {
        System.out.println(question + ": " + answer);
    }

    public void ask(String question, RoomMate roomMate) {
        new Thread(() -> roomMate.getAnswer(question, Student.this)).start();
        goToPlay();
    }

    public void goToPlay() {
        System.out.println("I'm going to play, call me after you finish ");
    }
}
