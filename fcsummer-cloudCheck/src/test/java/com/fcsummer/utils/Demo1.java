package com.fcsummer.utils;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.fcsummer.cloudCheck.CloudCheckApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Title: Demo1
 * @Author Fcsummer
 * @Package com.fcsummer.utils
 * @Date 2023/8/30 12:58
 * @description: demo1
 */
@SpringBootTest(classes = CloudCheckApplication.class)
public class Demo1 {

    @Test
    public void test1(){
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
