package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Category;

/**
 * @author Participate
 * @date 2022/10/27 9:40
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
