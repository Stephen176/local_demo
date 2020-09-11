package com.wz.demo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestService {
    public static void main(String[] args) {

    }

    private static void testSet() {
        Set<Integer> set = new LinkedHashSet<>();
//        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(null);
        set.add(null);
        set.add(1);
        set.add(2);

        System.out.println(set);
    }

    private static void testFinally() {
        try {
            System.out.println("I'm the inner of try");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("ha ha ha");
        }
    }

    private static void testURL() {
        try {
            URL url = new URL("https://www.zkong.com");
            InputStream inputStream = url.openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
