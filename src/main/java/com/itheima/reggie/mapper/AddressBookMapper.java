package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author Participate
 * @date 2022/10/28 23:54
 */
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {
}
