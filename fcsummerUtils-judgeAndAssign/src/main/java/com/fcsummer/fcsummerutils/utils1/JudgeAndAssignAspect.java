package com.fcsummer.fcsummerutils.utils1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        Object[] args = joinPoint.getArgs();
        ArrayList<Object> newArgList = new ArrayList<>();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        JudgeAndAssign judgeAndAssign = signature.getMethod().getAnnotation(JudgeAndAssign.class);
        boolean assign = judgeAndAssign.assign();
        boolean callBackNullProperty = judgeAndAssign.isCallBackNullProperty();
        String[] checkTypeNumbers = judgeAndAssign.value();
        List<String> checkTypeList = Arrays.asList(checkTypeNumbers);
        for (int i = 0; i < args.length; i++) {
            BackVo<Object> check = ForObjectAllNotNull.check(args[i], checkTypeList, callBackNullProperty, assign);
            newArgList.add(ForObjectAllNotNull.check(check.getBackObject(),checkTypeList,callBackNullProperty,assign));
        }
        Object[] newArgs = newArgList.toArray();
        Object result = joinPoint.proceed(newArgs);

        return result;
    }

}
