package com.pupupu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Summer
 * @version 1.0
 * @date 2019/11/3 19:32
 */

@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_StartSpringCloud_App {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527_StartSpringCloud_App.class,args);
    }
}
// 访问方式：http://自定义的网关名称：网关端口/自定义前缀/微服务名称的别名/访问方法的地址
//  http://zuul-gateway.com:9527/pupupu/deptproxy/dept/get/1
