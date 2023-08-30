package com.fcsummer.cloudCheck.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * @Title: MailUtil
 * @Author Fcsummer
 * @Package com.fcsummer.cloudCheck.util
 * @Date 2023/8/30 12:36
 * @description: 邮件发送工具类
 */
public class FcMailUtil {
    public static void sendMail(){
        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(587);
        account.setAuth(true);
        account.setFrom("2290291854@qq.com");
        account.setUser("2290291854@qq.com");
        account.setPass("xsmrizashozfeacf");
        MailUtil.send(account,"fcsummer111@outlook.com", "测试", "邮件来自Hutool测试", false);
    }

}
