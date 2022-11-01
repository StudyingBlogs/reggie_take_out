package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Participate
 * @date 2022/10/28 22:00
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
