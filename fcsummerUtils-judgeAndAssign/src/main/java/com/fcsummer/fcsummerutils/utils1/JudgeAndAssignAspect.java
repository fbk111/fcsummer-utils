package com.fcsummer.fcsummerutils.utils1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title: AspectJudgeAndAssign
 * @Author Fcsummer
 * @Package com.fcsummer.fcsummerutils.utils1
 * @Date 2023/8/25 15:27
 * @description: JudgeAndAssign注解的切面
 */
@Component
@Aspect
public class JudgeAndAssignAspect {


    @Pointcut(value = "@annotation(com.fcsummer.fcsummerutils.utils1.JudgeAndAssign)")
    public void pointcut(){

    }

    @Around("pointcut()")
    public Object beforeMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        JudgeAndAssign judgeAndAssign = methodSignature.getMethod().getDeclaringClass().getAnnotation(JudgeAndAssign.class);
        boolean assign = judgeAndAssign.assign();
        boolean callBackNullProperty = judgeAndAssign.isCallBackNullProperty();
        String[] value = judgeAndAssign.value();
        List<String> valueList = Arrays.stream(value).collect(Collectors.toList());
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            Class<?> property = args[i].getClass();
            BackVo backVo = ForObjectAllNotNull.check(property, valueList, callBackNullProperty, assign);
            Object backObject = backVo.getBackObject();
            args[i] = backObject;
        }
        return joinPoint.proceed(args);
    }
}
