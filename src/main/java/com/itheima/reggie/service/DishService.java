package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.dto.DishDto;
import com.itheima.reggie.entity.Dish;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Participate
 * @date 2022/10/27 10:59
 */
public interface DishService extends IService<Dish> {
    //新增菜品，同时插入菜品对应的口味数据，需要操作两张表：dish、dish_flavor
    public void saveWithFlavor(DishDto dishDto) ;

    public DishDto getByIdWithFlavor(Long id) ;

    void updateWithFlavor(DishDto dishDto);

    void removeWithFlavors(List<Long> ids);
}
