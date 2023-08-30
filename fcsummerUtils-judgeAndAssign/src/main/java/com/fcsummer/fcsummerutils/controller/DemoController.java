package com.fcsummer.fcsummerutils.controller;

import com.fcsummer.fcsummerutils.utils1.JudgeAndAssign;
import com.fcsummer.fcsummerutils.utils1.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: DemoController
 * @Author Fcsummer
 * @Package com.fcsummer.fcsummerutils.controller
 * @Date 2023/8/27 21:01
 * @description: 测试controller
 */
@Slf4j
@RestController
public class DemoController {


    @JudgeAndAssign(value = {"string","int","date"},isCallBackNullProperty = true,assign = true)
    @PostMapping ("/demo")
    public void demo(Person person) {
        System.out.println(person);
      log.error("测试");
    }


}
