package com.fcsummer.fcsummerutils.utils1;

import java.lang.annotation.*;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: JudgeAndAssign
 * @Author Fcsummer
 * @Package com.fcsummer.fcsummerutils.utils1
 * @Date 2023/8/25 15:15
 * @description: 判断属性并且赋值注解
 */
@Target({ElementType.PARAMETER,ElementType.METHOD,})
@Retention(RetentionPolicy.RUNTIME)
public @interface JudgeAndAssign {
    String[] value() default {""};
    boolean isCallBackNullProperty() default false;
    boolean assign() default false;
}
