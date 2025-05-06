package org.example.utils;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;

/**
 * 邮件发送工具类
 */
public class EmailUtils {
    
    // SMTP服务器配置
    private static final String HOST = "smtp.qq.com"; // 以QQ邮箱为例
    private static final int PORT = 465;
    private static final String FROM = "your-email@qq.com"; // 发件人邮箱
    private static final String PASSWORD = "your-smtp-password"; // 邮箱SMTP授权码
    
    // 静态邮件账户配置
    private static final MailAccount account;
    
    // 静态初始化块
    static {
        account = new MailAccount();
        account.setHost(HOST);
        account.setPort(PORT);
        account.setAuth(true);
        account.setFrom(FROM);
        account.setPass(PASSWORD);
        account.setSslEnable(true);
    }
    
    /**
     * 发送邮件
     * @param toEmail 收件人邮箱
     * @param content 邮件内容
     */
    public static void sendEmail(String toEmail, String content) {
        try {
            // 直接使用静态account发送邮件
            MailUtil.send(account, toEmail, "系统通知", content, false);
        } catch (Exception e) {
            throw new RuntimeException("发送邮件失败：" + e.getMessage());
        }
    }
}