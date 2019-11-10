package com.pupupu.springcloud.service.impl;

import com.pupupu.springcloud.entities.Dept;
import com.pupupu.springcloud.mapper.DeptMapper;
import com.pupupu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Summer
 * @version 1.0
 * @date 2019/10/26 11:34
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean add(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptMapper.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptMapper.findAll();
    }
}
