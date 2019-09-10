package com.hq.bamllordercomsumer.controller;

import mall.bean.UserAddress;
import mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: Mr.Huang
 * @create: 2019-09-09 14:51
 **/
@RestController
public class OrderController  {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/initOrder")
    public List<UserAddress>  initOrder(@RequestParam("uid")String userId){
        return orderService.initOrder(userId);
    }
}
