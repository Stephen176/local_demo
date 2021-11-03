package com.wz.thread;

import com.wz.thread.model.Person;

/**
 * author: jiangtaihe
 * date: 2021/10/11
 */
public class TestThreadLocal {
    public static void main(String[] args) {
        Person person = new Person();

        new Thread(() -> {
            person.setName("吴振");
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1=====" + person.getName());
        }).start();

        new Thread(() -> {
            person.setName("baby");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2=====" + person.getName());
        }).start();
    }
}
