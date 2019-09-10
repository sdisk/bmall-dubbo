package com.hq.bamllserviceprovider;

import com.alibaba.dubbo.config.annotation.Service;
import mall.bean.UserAddress;
import mall.service.UserAddressService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: @EnableDubbo(scanBasePackages = "com.hq.bamllserviceprovider.impl")用于扫码该包下面的类
 * @author: Mr.Huang
 * @create: 2019-09-10 11:20
 **/
@Service(timeout = 2000, retries = 3, version = "1.0.0")
@Component
public class MyOrderService implements UserAddressService {

    public void test(){

    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        return null;
    }
}
