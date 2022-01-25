package com.wz.jvm;

import com.wz.model.User;
import org.openjdk.jol.info.ClassLayout;

/**
 * author: jiangtaihe
 * date: 2021/11/4
 */
public class TestJOL {
    public static void main(String[] args) {
        Object o = new Object();
        User u = new User();
        System.out.println(ClassLayout.parseInstance(u).toPrintable());
        synchronized (u) {
            System.out.println(ClassLayout.parseInstance(u).toPrintable());
        }
    }
}
