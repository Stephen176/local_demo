package com.wz.thread;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: jiangtaihe
 * date: 2021/11/4
 */
public class TestConcurrent2 {
    private static int m = 0;
    private static AtomicInteger n = new AtomicInteger();

    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 10000; j++) {
                    m++;
                    n.incrementAndGet();
                }
            });
        }
        Arrays.stream(threads).forEach(thread -> thread.start());
        System.out.println("start all threads >>>");
        latch.countDown();
        // 必须睡一会儿，计算需要一定的时间
        try {
            Thread.sleep(3000);
//            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(m);
        System.out.println(n);
    }
}
