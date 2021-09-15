package com.wz.jvm.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * author: jiangtaihe
 * date: 2021/3/21
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }

    }
    static class OOMObject{}
}
