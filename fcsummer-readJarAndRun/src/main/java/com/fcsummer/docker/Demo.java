package com.fcsummer.docker;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.io.resource.ResourceUtil;
import com.fcsummer.config.DockerClientConfig;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.command.*;
import com.github.dockerjava.api.model.*;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.ExecStartResultCallback;
import lombok.SneakyThrows;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @Title: Demo
 * @Author Fcsummer
 * @Package com.fbk.readAndCompile.docker
 * @Date 2023/8/22 19:57
 * @description: docker的demo
 */
public class Demo {
    @SneakyThrows
    public static void main(String[] args) {
        DockerClient dockerClient = DockerClientConfig.getDockerClient();

        String image="openjdk:8-alpine";

        PullImageCmd pullImageCmd = dockerClient.pullImageCmd(image);
        PullImageResultCallback pullImageResultCallback = new PullImageResultCallback() {
            @Override
            public void onNext(PullResponseItem item) {
                super.onNext(item);
            }
        };

        pullImageCmd.exec(pullImageResultCallback).awaitCompletion();

        System.out.println("下载完成");


        //创建容器

        CreateContainerCmd containerCmd = dockerClient.createContainerCmd(image);
        HostConfig hostConfig = new HostConfig();
        //数据映射路径
        hostConfig.withMemory(100*1000*1000L);
        hostConfig.withCpuCount(1L);
        //允许内存交换的大小
        hostConfig.withMemorySwap(0L);
        String readUtf8Str = ResourceUtil.readUtf8Str("profile.json");
        hostConfig.withSecurityOpts(Arrays.asList("seccomp="+readUtf8Str));
        hostConfig.setBinds(new Bind("",new Volume("/app")));
        CreateContainerResponse createContainerResponse = containerCmd.withAttachStderr(true).withAttachStdin(true).withAttachStdout(true)
                .withHostConfig(hostConfig)
                .withTty(true)
                .withNetworkDisabled(true)
                .withReadonlyRootfs(true)
                .exec();

        String id = createContainerResponse.getId();

        StopWatch stopWatch = new StopWatch();
        String [] cmdArray=new String[]{"java","-cp","/app","Main","1","3"};
        ExecCreateCmdResponse execCreateCmdResponse = dockerClient.execCreateCmd(id).withCmd(cmdArray).withAttachStderr(true).withAttachStdin(true).withAttachStderr(true)
                .exec();


        String execCreateCmdResponseId = execCreateCmdResponse.getId();


       final boolean[] timeOutFlag={true};
        ExecStartResultCallback execStartResultCallback = new ExecStartResultCallback() {
            @Override
            public void onComplete() {
                timeOutFlag[0]=false;
            }
        };
        stopWatch.start();
        //只让他执行10s钟的时间
        dockerClient.execStartCmd(execCreateCmdResponseId).exec(execStartResultCallback).awaitCompletion(10, TimeUnit.SECONDS);

        stopWatch.stop();

        double totalTimeSeconds = stopWatch.getTotalTimeSeconds();


        StatsCmd statsCmd = dockerClient.statsCmd(id);

        ResultCallback<Statistics> statisticsResultCallback = statsCmd.exec(new ResultCallback<Statistics>() {
            @Override
            public void onStart(Closeable closeable) {

            }

            @Override
            public void onNext(Statistics statistics) {
                System.out.println(statistics.getMemoryStats().getUsage());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void close() throws IOException {

            }
        });

        statsCmd.exec(statisticsResultCallback).onComplete();
    }
}
