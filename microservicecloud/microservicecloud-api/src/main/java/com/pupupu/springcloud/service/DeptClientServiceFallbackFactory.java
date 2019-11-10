package com.pupupu.springcloud.service;

import com.pupupu.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务降级，当服务器已经down掉之后会有通知信息。
 * @author Summer
 * @version 1.0
 * @date 2019/11/3 11:49
 */

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("ID:" + id + ",没有对应的信息，Consumer客户端提供降级信息，此刻服务Provider已关闭")
                        .setDb_source("No database in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public Object discovery() {
                return null;
            }
        };
    }
}
