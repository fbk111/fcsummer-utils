package com.fcsummer.config;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import org.apache.commons.lang3.reflect.FieldUtils;

/**
 * @Title: Demo
 * @Author Fcsummer
 * @Package com.fcsummer.config
 * @Date 2023/8/26 18:58
 * @description: demo
 */
public class Demo {

    public static void main(String[] args) {
//        System.out.println(FileUtil.getpath(FileUtil.file(ResourceUtil.getResource("profile.json"))));
        System.out.println(ResourceUtil.getResource("profile.json").getPath());
    }
}
