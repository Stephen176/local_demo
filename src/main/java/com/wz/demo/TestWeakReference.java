package com.wz.demo;

import com.wz.model.User;

import java.lang.ref.WeakReference;

/**
 * author: jiangtaihe
 * date: 2021/11/3
 */
public class TestWeakReference {
    public static void main(String[] args) {
        WeakReference<User> u = new WeakReference<>(new User());
        System.out.println(u.get());
        System.gc();
        System.out.println(u.get());
    }
}
