package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Participate
 * @date 2022/10/25 12:39
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
