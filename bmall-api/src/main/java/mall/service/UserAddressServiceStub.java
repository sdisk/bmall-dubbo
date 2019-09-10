package mall.service;

import mall.bean.UserAddress;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @description: 本地存根
 * @author: Mr.Huang
 * @create: 2019-09-09 16:01
 **/
public class UserAddressServiceStub implements UserAddressService {

    private final UserAddressService userAddressService;

    /**
     * 传入的是userAddressService的远程对象
     * 构造函数传入真正的远程代理对象
     * @param userAddressService
     */
    public UserAddressServiceStub(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("使用UserAddressServiceStub");
        //进行判断
        if (StringUtils.isEmpty(userId)){
            return null;
        }
        return userAddressService.getUserAddressList(userId);

    }
}
