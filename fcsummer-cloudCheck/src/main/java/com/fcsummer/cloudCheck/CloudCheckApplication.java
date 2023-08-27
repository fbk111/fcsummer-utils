package com.fcsummer.cloudCheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Title: CloudCheckApplication
 * @Author Fcsummer
 * @Package com.fcsummer.cloudCheck
 * @Date 2023/8/26 18:07
 * @description: 云盘启动类
 */
@EnableScheduling
@SpringBootApplication
public class CloudCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudCheckApplication.class,args);
    }
}
