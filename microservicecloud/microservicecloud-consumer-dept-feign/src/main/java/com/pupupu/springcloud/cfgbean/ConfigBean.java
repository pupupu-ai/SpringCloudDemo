package com.pupupu.springcloud.cfgbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Summer
 * @version 1.0
 * @date 2019/10/26 13:50
 */
@Configuration
public class ConfigBean {

    /**
     * 类似RedisTemplate，提供了多种边界访问远程http服务的方法
     * 是一种简单便捷的访问restful服务模板类，是spring提供的用于访问Rest服务的客户端模板工具类
     * 关于RestTemplate可参考：https://blog.csdn.net/itguangit/article/details/78825505
     */

    @Bean
    @LoadBalanced   // 开启负载均衡 Spring cloud ribbon 是基于netflix Ribbon实现的一套客户端 负载均衡的工具
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //默认为轮询选择算法，使用随机算法会替代默认的轮询选择算法
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }

}
