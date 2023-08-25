package com.fcsummer.fcsummerutils.utils1;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.ToString;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * @Title: JudgePropertyType
 * @Author Fcsummer
 * @Package com.fcsummer.fcsummerutils.utils1
 * @Date 2023/8/24 20:09
 * @description: 判断属性类型
 */
public class JudgePropertyType {
    @SneakyThrows
    public static <T> void assignProperty(T object, Field property) {

        Class<?> type = property.getType();
        if (isPrimitiveType(type)) {
            judgePrimitiveTypeAndAssign(object, property);
        } else {
            property.set(object, type.newInstance());
        }
    }

    @SneakyThrows
    public static <T> void judgePrimitiveTypeAndAssign(T object, Field property) {
        Class<?> propertyType = property.getType();
        if (propertyType == int.class) {
            property.setInt(object, 1);
        } else if (propertyType == boolean.class) {
            property.setBoolean(object, false);
        } else if (propertyType == char.class) {
            property.setChar(object, 'A');
        } else if (propertyType == byte.class) {
            property.setByte(object, (byte) 5);
        } else if (propertyType == short.class) {
            property.setShort(object, (short) 100);
        } else if (propertyType == long.class) {
            property.setLong(object, 1L);
        } else if (propertyType == float.class) {
            property.setFloat(object, 1.0f);
        } else if (propertyType == double.class) {
            property.setDouble(object, 1.0);
        }
    }

    public static boolean isPrimitiveType(Class<?> type) {
        return type.isPrimitive();
    }
}
