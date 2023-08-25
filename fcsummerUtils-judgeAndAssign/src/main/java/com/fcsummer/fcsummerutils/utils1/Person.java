package com.fcsummer.fcsummerutils.utils1;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Person {
    private String name;
    private int age;

    private Date date;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
