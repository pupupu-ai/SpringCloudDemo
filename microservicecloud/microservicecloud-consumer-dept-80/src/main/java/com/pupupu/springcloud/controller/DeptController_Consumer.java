package com.pupupu.springcloud.controller;

import com.pupupu.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Summer
 * @version 1.0
 * @date 2019/10/26 14:00
 */
@RestController
public class DeptController_Consumer {

    /**
     *  使用RestTemplate访问restful接口
     *  (url、requsetMap、ResponseBean.class)
     *  REST请求地址、请求参数、HTTP响应转换成的对象类型
     */

    @Autowired
    private RestTemplate restTemplate;

    //private static final String REST_URL_PREFIX = "http://localhost:8081";
    /**
     * 注册在EurekaServer中的微服务名称
     */
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT"; //微服务名字

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return  restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }
}
