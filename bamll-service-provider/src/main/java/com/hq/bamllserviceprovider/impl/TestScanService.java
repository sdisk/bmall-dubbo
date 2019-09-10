package com.hq.bamllserviceprovider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import mall.bean.UserAddress;
import mall.service.UserAddressService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: Mr.Huang
 * @create: 2019-09-10 11:22
 **/
@Service
@Component
public class TestScanService implements UserAddressService {

    public void test(){

    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        return null;
    }
}
