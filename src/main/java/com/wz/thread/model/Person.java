package com.wz.thread.model;

/**
 * author: jiangtaihe
 * date: 2021/10/11
 */
public class Person {
    private ThreadLocal<String> name = new ThreadLocal<>();

    public String getName() {
        return this.name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
