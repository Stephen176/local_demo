package com.wz.demo;

import java.io.File;
import java.io.IOException;

public class InvalidFileTest {

    private final static String path = "C:\\Users\\Administrator\\Documents\\DSC\\dasV";

    public static void main(String[] args) throws IOException {
        String fileName = path + "\\.\\aa1.log";
        File file = new File(fileName);
        System.out.println(file.exists());
        System.out.println(file.createNewFile());
        System.out.println(file.getAbsolutePath());
    }
}
