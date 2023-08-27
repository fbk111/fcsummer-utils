package com.fcsummer.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.SneakyThrows;

import java.io.*;

/**
 * @Title: CompileClassUtils
 * @Author Fcsummer
 * @Package com.fbk.readjar.utils
 * @Date 2023/8/20 13:27
 * @description: 编译class文件工具类
 */
public class CompileClassUtils {

    /**
     * @param absoluteClassPath
     * @param xmx
     * @param xms
     * @param timeLoad
     * @param args
     */
    @SneakyThrows
    public static void compileClassUtils(String absoluteClassPath, String xmx, String xms, Long timeLoad, String args) {
        File file = new File(absoluteClassPath);
        String parentPath;
        if (!file.exists()) {
            throw new IOException("文件不存在");
        } else {
            parentPath = file.getParentFile().getAbsolutePath();
            FileUtil.mkdir(parentPath);
        }
        if (StrUtil.isEmpty(xms)) {
            xms = "256";
        }
        if (StrUtil.isEmpty(xmx)) {
            xmx = "256";
        }
        String runCmd = String.format("javac -Xmx%s -Xms%s -Dfile.encoding=UTF-8 -Djava.security.manger=%s -cp %s Main", xmx, xms, "DefaultSecurityConfig", absoluteClassPath);
        if (args != null) {
            String[] split = args.split(" ");
            String join = StrUtil.join("\n", split) + "\n";
            runCmd = String.format("javac -Xmx%s -Xms%s -Dfile.encoding=UTF-8 -Djava.security.manger=%s -cp %s Main %s", xmx, xms, "DefaultSecurityConfig", absoluteClassPath, join);
        }
        Process process = Runtime.getRuntime().exec(runCmd);

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(timeLoad);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                process.destroy();
            }

        });
        thread.setDaemon(true);
        thread.start();
        int waitForStatus = process.waitFor();

        /**
         * 返回值为 0：表示进程正常终止。这意味着执行的命令成功完成，没有发生错误。
         * 返回值为非零正整数：表示进程异常终止。具体的返回值通常是与操作系统相关的错误码或状态码。不同的非零返回值可能表示不同的错误情况，可以根据具体的返回值进行错误处理。
         */

        if (waitForStatus == 0) {
            try (BufferedReader bfr = new BufferedReader(new InputStreamReader(process.getInputStream()));
                 BufferedWriter bfw = new BufferedWriter(new FileWriter(parentPath))) {
                String line;
                while ((line = bfr.readLine()) != null) {
                    bfw.write(line);
                }
            }
        } else {
            try (BufferedReader bfr = new BufferedReader(new InputStreamReader(process.getInputStream()));
                 BufferedWriter bfw = new BufferedWriter(new FileWriter(parentPath))) {
                String line;
                while ((line = bfr.readLine()) != null) {
                    bfw.write(line);
                }
            }
        }
    }
}
