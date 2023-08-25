package com.fcsummer.fcsummerutils;

import com.fcsummer.fcsummerutils.utils1.Demo;
import com.fcsummer.fcsummerutils.utils1.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = FcsummerUtilsApplicationTests.class)
class FcsummerUtilsApplicationTests {

    @Test
    void contextLoads() {

        new Demo().demo1(new Person("fbk",111));
    }

}
