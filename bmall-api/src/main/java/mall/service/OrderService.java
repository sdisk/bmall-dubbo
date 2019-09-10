package mall.service;

import mall.bean.UserAddress;

import java.util.List;

/**
 * @description:
 * @author: Mr.Huang
 * @create: 2019-09-06 11:06
 **/
public interface OrderService {

    /**
     * 初始化订单
     * @param userId
     */
    List<UserAddress> initOrder(String userId);
}
