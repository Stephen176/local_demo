package org.example.utils;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;

/**
 * 邮件发送工具类
 */
public class EmailUtils {
    
    // SMTP服务器配置
    private static final String HOST = "smtp.163.com";
    private static final int PORT = 25; // 修改为25端口
    private static final String FROM = "17621322644@163.com";
    private static final String PASSWORD = "GWnS6GjqDk2edr4X";
    
    // 静态邮件账户配置
    private static final MailAccount account;
    
    // 静态初始化块
    static {
        account = new MailAccount();
        account.setHost(HOST);
        account.setPort(PORT);
        account.setAuth(true);
        account.setFrom(FROM);
        account.setUser(FROM); // 添加用户名配置
        account.setPass(PASSWORD);
        account.setSslEnable(false); // 关闭SSL
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

    public static void main(String[] args) {
        String toEmail = "1033797878@qq.com";
        String content = "如果仍然失败检查163邮箱服务器状态，可能临时维护联系网络管理员，确认是否屏蔽了SMTP端口考虑使用企业邮箱或其他邮件服务商希望这些解决方案能帮助你解决问题！如果仍有问题，可以提供具体的错误堆栈信息，我可以进一步帮你分析。本回答由 AI 生成，内容仅供参考，请仔细甄别。";
        sendEmail(toEmail, content);
    }
}