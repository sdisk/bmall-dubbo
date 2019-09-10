package mall.service;


import mall.bean.UserAddress;

import java.util.List;

/**
 * @description: 用户地址接口
 * @author: Mr.Huang
 * @create: 2019-09-06 10:51
 **/
public interface UserAddressService {
    /**
     * 根据用户id查询所有的收货地址
     * @param userId
     * @return List<UserAddress>
     */
    List<UserAddress> getUserAddressList(String userId);
}
