package com.fcsummer.cloudCheck.util;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @Title: FcDateUtils
 * @Author Fcsummer
 * @Package com.fcsummer.cloudCheck.util
 * @Date 2023/8/31 15:13
 * @description: date的工具类
 */
public class FcDateUtils {

    public static Integer getDateOfMonth(){
        Date date = new Date();
        return DateUtil.dayOfMonth(date)-1;
    }

    public static void main(String[] args) {
        System.out.println(getDateOfMonth());
    }
}
