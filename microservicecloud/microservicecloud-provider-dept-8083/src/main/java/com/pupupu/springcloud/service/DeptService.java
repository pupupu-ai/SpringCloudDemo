package com.pupupu.springcloud.service;

import com.pupupu.springcloud.entities.Dept;

import java.util.List;

/**
 * @author Summer
 * @version 1.0
 * @date 2019/10/26 11:32
 */
public interface DeptService {

    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}
