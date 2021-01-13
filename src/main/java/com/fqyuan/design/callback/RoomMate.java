package com.fqyuan.design.callback;

import java.util.concurrent.TimeUnit;

/**
 * @author fqyuan
 */
public class RoomMate {
    /**
     * 调用回调方法处可以传递消息给回调方法实现处
     *
     * @param question
     * @param callback
     */
    public void getAnswer(String question, Callback callback) {
        if ("1+1=".equals(question)) {
            callback.doHomeWork(question, "2");
        } else if ("1/0=".equals(question)) {
            for (int i = 0; i < 3; i++) {
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            callback.doHomeWork(question, "+∞");
        } else {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            callback.doHomeWork(question, "NA");
        }
    }
}
