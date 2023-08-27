package com.fcsummer.fcsummerutils.utils1;

import org.springframework.stereotype.Component;

/**
 * @Title: Demo
 * @Author Fcsummer
 * @Package com.fcsummer.fcsummerutils.utils1
 * @Date 2023/8/25 16:14
 * @description: 测试
 */
@Component
public class Demo {

    public static void main(String[] args) {
        new Demo().demo1(new com.fcsummer.fcsummerutils.utils1.Person("fbk",10));
    }


    @JudgeAndAssign
    public void demo1(@JudgeAndAssign Person person){
        System.out.println("执行");
    }
}
