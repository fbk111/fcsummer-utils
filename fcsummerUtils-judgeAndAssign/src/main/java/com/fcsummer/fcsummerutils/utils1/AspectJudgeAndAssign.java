package com.fcsummer.fcsummerutils.utils1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Title: AspectJudgeAndAssign
 * @Author Fcsummer
 * @Package com.fcsummer.fcsummerutils.utils1
 * @Date 2023/8/25 15:27
 * @description: JudgeAndAssign注解的切面
 */
@Component
@Aspect
public class AspectJudgeAndAssign {


    @Pointcut(value = "@annotation(com.fcsummer.fcsummerutils.utils1.JudgeAndAssign)")
    public void pointcut(){

    }

    @Around("pointcut()")
    public Object beforeMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
        return null;
    }
}
