package com.pupupu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Summer
 * @version 1.0
 * @date 2019/10/24 11:46
 */
@Data //getter、setter等
@NoArgsConstructor  //无参构造函数
@AllArgsConstructor  //全参构造函数
@Accessors(chain = true)//如果为true生成的set方法返回this，为false生成的set方法是void类型
//微服务需要实现序列化接口
public class Dept implements Serializable {

    private Long deptno;  //部门编码 主键
    private String dname;  //部门名称
    private String db_source; //数据库名称  来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同的数据库中

}
