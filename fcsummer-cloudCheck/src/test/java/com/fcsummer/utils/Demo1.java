package com.fcsummer.utils;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.fcsummer.cloudCheck.CloudCheckApplication;
import com.fcsummer.cloudCheck.request.AlRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * @Title: Demo1
 * @Author Fcsummer
 * @Package com.fcsummer.utils
 * @Date 2023/8/30 12:58
 * @description: demo1
 */
@SpringBootTest(classes = CloudCheckApplication.class)
@TestPropertySource(locations = "classpath:application.yml")
public class Demo1 {

    @Test
    public void test1(){
        AlRequest.getStart();
    }

}
