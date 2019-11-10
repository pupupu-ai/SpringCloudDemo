package com.pupupu.springcloud;

import com.pupupu.ribbonrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Summer
 * @version 1.0
 * @date 2019/10/26 14:40
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.pupupu.springcloud"})
public class DeptConsumer80_Feign_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign_App.class,args);
    }
}
