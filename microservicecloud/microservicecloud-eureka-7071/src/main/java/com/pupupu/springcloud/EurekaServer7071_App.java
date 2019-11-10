package com.pupupu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Summer
 * @version 1.0
 * @date 2019/10/27 11:03
 */
@SpringBootApplication
@EnableEurekaServer  // EurekaServer服务端启动类，接受其他微服务注册进来
public class EurekaServer7071_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7071_App.class,args);
    }
}
