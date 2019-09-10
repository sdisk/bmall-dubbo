package com.hq.bamllserviceprovider.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import mall.bean.UserAddress;
import mall.service.UserAddressService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 实现类
 * @author: Mr.Huang
 * @create: 2019-09-06 10:51
 **/

@Service(timeout = 5000, retries = 3, version = "2.0.0")
@Component
public class UserAddressServiceImpl2 implements UserAddressService {

    @Override
    @HystrixCommand
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("2.0.0版本方法");
        UserAddress userAddress1 = new UserAddress(1, "四川省成都市青羊区西南财经大学2栋3层305", "1", "李敏", "15932457878", "N");
        UserAddress userAddress2 = new UserAddress(2, "四川省成都市武侯区武侯祠7栋1层108", "1", "李敏", "15932457878", "Y");
        List<UserAddress> list = new ArrayList<UserAddress>(2);
        list.add(userAddress1);
        list.add(userAddress2);
        if (Math.random() > 0.5){
            System.out.println("出现异常");
            throw new RuntimeException();
        }
        return list;
    }
}
