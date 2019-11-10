package com.pupupu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Summer
 * @version 1.0
 * @date 2019/10/26 11:48
 */
@SpringBootApplication
@EnableEurekaClient     // 本服务启动后自动注册进eureka服务中
@EnableDiscoveryClient  // 服务发现
public class DeptProvider8083_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8083_App.class,args);
    }
}
