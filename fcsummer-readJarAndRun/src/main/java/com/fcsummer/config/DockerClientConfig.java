package com.fcsummer.config;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Title: DcokerConfigClient
 * @Author Fcsummer
 * @Package com.fcsummer.config
 * @Date 2023/8/26 17:33
 * @description: 配置docker-client
 */
public class DockerClientConfig {

    @Value("${fcsummer.docker.tcp}")
    private static String tcp;
    public static DockerClient getDockerClient(){
        DefaultDockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                .withDockerHost(tcp)
                .build();
        return DockerClientBuilder.getInstance(config).build();

    }

}
