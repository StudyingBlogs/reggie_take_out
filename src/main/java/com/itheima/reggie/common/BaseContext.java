package com.itheima.reggie.common;

/**
 * @author Participate
 * @date 2022/10/27 9:18
 * 基于ThreadLocal封装工具类，用户保存和获取当前用户登录ID
 */
public class BaseContext {
    //作用域是一个线程
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }
    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
