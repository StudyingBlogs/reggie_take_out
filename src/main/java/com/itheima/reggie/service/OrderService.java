package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Orders;

/**
 * @author Participate
 * @date 2022/10/29 11:15
 */
public interface OrderService extends IService<Orders> {
    public void submit(Orders orders);
}
