package com.wz.thread;

/**
 * author: jiangtaihe
 * date: 2021/9/16
 */
public class TestThisEscape {
    public int num = 99;

    public TestThisEscape() {
        new Thread(() -> System.out.println(this.num)).start();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new TestThisEscape();
        }
        System.out.println("---------");
    }
}
