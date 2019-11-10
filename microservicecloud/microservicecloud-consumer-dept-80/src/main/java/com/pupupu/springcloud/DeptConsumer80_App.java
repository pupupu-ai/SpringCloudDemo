package com.pupupu.springcloud;

import com.pupupu.ribbonrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Summer
 * @version 1.0
 * @date 2019/10/26 14:40
 */
@SpringBootApplication
@EnableEurekaClient
// 在启动该微服务的时候去加载我们自定义的Ribbon配置（负载均衡算法），从而使配置生效
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
public class DeptConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class,args);
    }
}
