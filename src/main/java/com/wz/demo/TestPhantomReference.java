package com.wz.demo;

import com.wz.model.User;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * author: jiangtaihe
 * date: 2021/11/3
 */
public class TestPhantomReference {

    private static final ArrayList<Byte[]> LIST = new ArrayList<>();
    private static final ReferenceQueue<User> QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) {
        PhantomReference<User> phantomReference = new PhantomReference<>(new User(), QUEUE);
        System.out.println(phantomReference.get());

        new Thread(() -> {
            while (true) {
                LIST.add(new Byte[1024 * 1024]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(phantomReference.get());
            }
        }).start();

        //垃圾回收线程
        new Thread(() -> {
            while (true) {
                Reference<? extends User> poll = QUEUE.poll();
                if (poll != null) {
                    System.out.println("-------虚引用对象被JVM回收了" + poll);
                }
            }
        }).start();
    }
}
