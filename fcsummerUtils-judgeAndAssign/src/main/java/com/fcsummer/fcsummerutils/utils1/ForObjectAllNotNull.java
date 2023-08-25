package com.fcsummer.fcsummerutils.utils1;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title: ForObjectAllNotNull
 * @Author Fcsummer
 * @Package com.fcsummer.fcsummerutils.utils1
 * @Date 2023/8/24 19:38
 * @description: 检验所有数字字符串均不为空
 */
public class ForObjectAllNotNull {

    /**
     *
     * @param object
     * @param propertyTypes
     * @param isCallBackNullProperty
     * @param assign
     * @return
     * @param <T>
     */
    @SneakyThrows
    public static <T> BackVo<T> check(T object, List<String> propertyTypes, boolean isCallBackNullProperty, boolean assign) {
        BackVo<T> backVo = new BackVo<>();
        List<String> lowerPropertyTypes = propertyTypes.stream().map(String::toLowerCase).collect(Collectors.toList());
        Field[] fields = object.getClass().getDeclaredFields();
        boolean containsEmpty = true;
        ArrayList<String> callBackPropertyList = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);
            String typeName = field.getType().getSimpleName().toLowerCase();
            String fieldName = field.getName();
            Object value = field.get(object);

            if (lowerPropertyTypes.contains(typeName)) {
                if (value == null) {
                    containsEmpty = false;
                    if (isCallBackNullProperty) {
                        callBackPropertyList.add(fieldName);
                    }
                    if(assign){
                        JudgePropertyType.assignProperty(object,field);
                    }
                }
            }
        }

        backVo.setCallBackPropertyList(callBackPropertyList);
        backVo.setContainsEmpty(containsEmpty);
        backVo.setBackObject(object);
        return backVo;
    }


    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(18);
        BackVo<Person> name = check(person, Arrays.asList("string","date"), true, true);
        System.out.println(name);
    }

}
