package com.fcsummer.fcsummerutils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Title: JudgeAndAssignApplication
 * @Author Fcsummer
 * @Package com.fcsummer.fcsummerutils.utils1
 * @Date 2023/8/27 20:54
 * @description: judgeAndAssign启动类
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class JudgeAndAssignApplication {
    public static void main(String[] args) {
        SpringApplication.run(JudgeAndAssignApplication.class,args);
    }
}
