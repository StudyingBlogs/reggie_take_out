package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.User;

/**
 * @author Participate
 * @date 2022/10/28 22:01
 */
public interface UserService extends IService<User> {
    void sendMsg(String to,String subject,String text);
}
