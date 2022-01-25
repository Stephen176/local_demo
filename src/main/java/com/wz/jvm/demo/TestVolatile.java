package com.wz.jvm.demo;

import java.util.concurrent.TimeUnit;

/**
 * author: jiangtaihe
 * date: 2021/11/5
 */
public class TestVolatile {
   /*volatile*/ boolean flag = true;

    void m() {
        System.out.println("m start >>>");
        while (flag) {
            // 可能造成内存同步
//            System.out.println("----------------");
        }
        System.out.println("m end   <<<");
    }

    public static void main(String[] args) throws InterruptedException {
        TestVolatile t = new TestVolatile();
        new Thread(t::m,"thread-1").start();

        TimeUnit.SECONDS.sleep(1);
        t.flag = false;
    }
}
