package com.wz.demo;

import java.util.*;

/**
 * 找出最长对称字符串
 *
 * @author 吴振
 * @phone 176 2132 2644
 */
public class Test1 {
    public static void main(String[] args) {
        String s = "sjld胜利大街是-+=连接端口4567$%^&*(";
        String[] split = s.split("\\W");

        String str = "ana";
        String substring = str.substring(1, 1);
        System.out.println(substring);

        // TODO 输出最长对称字符串：goog
        String input1 = "google";

        // TODO 输出3个最长对称字符串：aba/aca/ada
        String input2 = "abcda";

        // TODO 输出2个最长对称字符串：pop/upu，不会输出特殊字符的对称字符串p-p
        String input3 = "poplupuuu";

    }

    public static Set<String> getSymmetryStrings(String input) {
        Set<String> resultSet = new HashSet<>();
        if (input == null || input.length() <= 1) {
            System.out.println("invalid param");
        }
        String[] split = input.split("\\W");
        for (String s : split) {
            List<Region> possibleRegions = getPossibleRegions(s);
        }

        return resultSet;
    }

    public static List<Region> getPossibleRegions(String str) {
        List<Region> list = new ArrayList<>();
        if (str.length() <= 1) {
            Region region = new Region();
            region.setSubStr(str);
            list.add(region);
            return list;
        }

        int lastEndIndex = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            int lastIndex = str.lastIndexOf(aChar);
            // 如果当前子串被包含在之前截取过的子串
            if (lastIndex <= lastEndIndex) {
                continue;
            }
            if (lastIndex != i) {
                String subStr = str.substring(i + 1, lastIndex);
                Region region = new Region();
                region.setCharacter(aChar);
                region.setSubStr(subStr);
                region.setSubRegions(getPossibleRegions(subStr));
                list.add(region);
                lastEndIndex = lastIndex;
            }
        }
        if (lastEndIndex == 0) {
            Region region = new Region();
            region.setSubStr(str);
            list.add(region);
        }
        return list;
    }


    static class Region {
        private char character;
        private String subStr;
        private List<Region> subRegions;

        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }

        public String getSubStr() {
            return subStr;
        }

        public void setSubStr(String subStr) {
            this.subStr = subStr;
        }

        public List<Region> getSubRegions() {
            return subRegions;
        }

        public void setSubRegions(List<Region> subRegions) {
            this.subRegions = subRegions;
        }
    }
}
