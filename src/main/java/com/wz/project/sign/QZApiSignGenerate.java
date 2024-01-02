package com.wz.project.sign;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * author: jiangtaihe
 * date: 2024/1/2
 */
public class QZApiSignGenerate {
    private final static String signRawStrTemplate = "signType=md5&accessKey=%s&secretKey=%s&timestamp=%s";

    public static void main(String[] args) {
        String accessKey = "apitest";
        String secretKey = "qzkj@1001";
        long timeMillis = System.currentTimeMillis();
        System.out.println(timeMillis);
        String formatStr = String.format(signRawStrTemplate, accessKey, secretKey, timeMillis);
        try {
            String s = MD5(formatStr);
            System.out.println(s);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static String MD5(String data) throws
            NoSuchAlgorithmException, UnsupportedEncodingException {
        java.security.MessageDigest md =
                MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) |
                    0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }
}
