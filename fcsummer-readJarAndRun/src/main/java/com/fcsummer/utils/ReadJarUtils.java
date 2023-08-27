package com.fcsummer.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import lombok.SneakyThrows;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @Title: ReadJarUtils
 * @Author Fcsummer
 * @Package com.fbk.readjar.utils
 * @Date 2023/8/20 12:16
 * @description: 读取jar文件
 */
public class ReadJarUtils {

    @SneakyThrows
    public static void readJarForAbsolute(String absoluteFilePath, String absoluteDownPath) {
        if (StrUtil.isEmpty(absoluteFilePath)) {
            throw new Exception("jar包为空");
        }
        File file = new File(absoluteFilePath);
        if (!file.exists() && !file.getParentFile().getAbsoluteFile().exists()) {
            throw new Exception("文件不存在");
        }else{
            absoluteDownPath+=File.separator+file.getName()+ UUID.randomUUID()+File.separator;
        }
        if (StrUtil.isEmpty(absoluteDownPath)) {
            absoluteDownPath = file.getParentFile().getAbsolutePath();
        }
        try (JarFile jarFile = new JarFile(absoluteFilePath)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                String name = entry.getName();
                if (!entry.isDirectory()&&name.endsWith(".class")) {
                    try (BufferedInputStream bui = new BufferedInputStream(jarFile.getInputStream(entry)); BufferedOutputStream buo = new BufferedOutputStream(new FileOutputStream(absoluteDownPath + name))) {
                        FileUtil.mkdir(absoluteDownPath +File.separator+ name);
                        byte[] bytes = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = bui.read(bytes)) != -1) {
                            buo.write(bytes, 0, bytesRead);
                        }
                    }
                } else if(entry.isDirectory()) {
                    FileUtil.mkdir(absoluteDownPath +File.separator+ name);
                }
            }
        }
    }
}
