package com.fcsummer.fcsummerutils;

import com.fcsummer.fcsummerutils.utils1.Demo;
import com.fcsummer.fcsummerutils.utils1.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = JudgeAndAssignApplication.class)
class FcsummerUtilsApplicationTests {


    @Autowired
    private ApplicationContext applicationContext;
    @Test
    void contextLoads() {
        Object demo = applicationContext.getBean(Demo.class);
        System.out.println(demo);

        new Demo().demo1(new Person("fbk",111));
    }

}
