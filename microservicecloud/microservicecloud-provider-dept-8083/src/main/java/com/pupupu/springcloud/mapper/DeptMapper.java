package com.pupupu.springcloud.mapper;


import com.pupupu.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Summer
 * @version 1.0
 * @date 2019/10/26 11:19
 */
@Mapper
public interface DeptMapper {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
