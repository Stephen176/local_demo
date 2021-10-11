package com.wz.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出最长对称字符串
 *
 * @author Your Name
 */
public class Test1 {
    public static void main(String[] args) {
        // TODO 输出最长对称字符串：goog
        String input1 = "google";

        // TODO 输出3个最长对称字符串：aba/aca/ada
        String input2 = "abcda";

        // TODO 输出2个最长对称字符串：pop/upu，不会输出特殊字符的对称字符串p-p
        String input3 = "pop-upu";

        String input4 = "ababab";
        String input5 = "abcedecba";
        List<String> result = findMaxLengthSymmetryStr(input2);
        System.out.println(result);

    }

    private static List<String> findMaxLengthSymmetryStr(String input) {
        List<String> symmetryStrs = new ArrayList<>();
        //根据字符和数字以外的特殊字符作为正则切割字符串
        String[] split = input.split("\\W");
        for (String str : split) {
            for (int i = 0; i < str.length(); i++) {
                char left = str.charAt(i);
                String remainingStr = "";
                StringBuilder sb = new StringBuilder();
                for (int j = str.length() - 1; j > i; j--) {
                    char right = str.charAt(j);
                    if (left == right) {
                        sb.append(left);
                        if (j > i + 1) {
                            String substring = str.substring(i + 1, j);
                            if (substring.length() == 1 || !containsDuplicateChar(substring)) {
                                remainingStr = substring;
                            } else {
                                remainingStr = loopFind(sb, substring);
                            }
                        }
                        break;
                    }
                }

                if (sb.length() == 0) {
                    continue;
                }
                if (remainingStr.length() > 0) {
                    for (char c : remainingStr.toCharArray()) {
                        symmetryStrs.add(sb.toString() + c + sb.reverse().toString());
                    }
                } else {
                    symmetryStrs.add(sb.toString() + sb.reverse().toString());
                }
            }
        }

        return getMaxlengthStrs(symmetryStrs);
    }

    private static String loopFind(StringBuilder sb, String subStr) {
        String remainingStr = "";
        a:
        for (int i = 0; i < subStr.length(); i++) {
            char left = subStr.charAt(i);
            for (int j = subStr.length() - 1; j > i; j--) {
                char right = subStr.charAt(j);
                if (left == right) {
                    sb.append(left);
                    if (j > i + 1) {
                        String substring = subStr.substring(i + 1, j);
                        if (substring.length() == 1 || !containsDuplicateChar(substring)) {
                            return substring;
                        }
                        remainingStr = loopFind(sb, substring);
                    }
                    break a;
                }
            }
        }
        return remainingStr;
    }

    /**
     * 筛选出字符串集合中 长度最长的字符串，结果可能是多个
     *
     * @param strings
     * @return
     */
    private static List<String> getMaxlengthStrs(List<String> strings) {
        List<String> result = new ArrayList<>();
        int max = 1;
        for (String string : strings) {
            if (string.length() > max) {
                max = string.length();
                result.clear();
                result.add(string);
            } else if (string.length() == max) {
                result.add(string);
            }
        }
        return result;
    }

    /**
     * 判断字符串中是否有重复的字符出现
     *
     * @param str
     * @return
     */
    private static boolean containsDuplicateChar(String str) {
        for (char c : str.toCharArray()) {
            int start = str.indexOf(c);
            int end = str.lastIndexOf(c);
            if (start != end) {
                return true;
            }
        }
        return false;
    }
}
