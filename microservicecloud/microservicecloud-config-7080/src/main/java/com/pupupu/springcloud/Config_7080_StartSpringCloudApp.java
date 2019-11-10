package com.pupupu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Summer
 * @version 1.0
 * @date 2019/11/9 16:33
 */
@SpringBootApplication
@EnableConfigServer
public class Config_7080_StartSpringCloudApp {
    public static void main(String[] args) {
        SpringApplication.run(Config_7080_StartSpringCloudApp.class,args);
    }
}
