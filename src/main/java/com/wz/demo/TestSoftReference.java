package com.wz.demo;

import java.lang.ref.SoftReference;

/**
 * author: jiangtaihe
 * date: 2021/11/3
 */
public class TestSoftReference {
    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());

        byte[] b = new byte[1024 * 1024 * 12];
        System.out.println(m.get());
    }
}
