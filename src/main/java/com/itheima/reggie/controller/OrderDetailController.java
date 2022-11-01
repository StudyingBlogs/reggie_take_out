package com.itheima.reggie.controller;

import com.itheima.reggie.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Participate
 * @date 2022/10/29 11:19
 */
@RestController
@Slf4j
@RequestMapping
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;
}
