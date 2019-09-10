package com.hq.bamllordercomsumer.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import mall.bean.UserAddress;
import mall.service.OrderService;
import mall.service.UserAddressService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 　配置优先级：　方法级优先，接口级次之，全局配置再次之；
 *  如果级别一样，则消费方优先，提供方次之
 *
 *  总结：细节优先，消费者优先
 * @description:
 * @author: Mr.Huang
 * @create: 2019-09-06 11:07
 **/
@Service
public class OrderServiceImpl implements OrderService {

    //@Reference(timeout = 3000) stub:配置本地存根 url直连，绕过注册中心
    //@Reference(version = "2.0.0", stub = "mall.service.UserAddressServiceStub", url="127.0.0.1:20880")
    //@Reference(version = "2.0.0", stub = "mall.service.UserAddressServiceStub")
    @Reference(loadbalance = "random", version = "*", timeout = 3000)
    UserAddressService userAddressService;

    @HystrixCommand(fallbackMethod = "handlerException")
    @Override
    public List<UserAddress>  initOrder(String userId) {
        //1.查询用户的收货地址
        System.out.println("userId:"+ userId);
        List<UserAddress> addressList = userAddressService.getUserAddressList(userId);
        System.out.println(addressList);
        return addressList;
    }
    /**
     * 表示调用出错后进行的处理,这里没有处理直接返回null
     * @param userId
     * @return
     */
    public List<UserAddress> handlerException(String userId) {
        System.out.println("使用Hystrix进行消费者调用提供者方法容错");
        return null;
    }
}
