package mall.bean;

import java.io.Serializable;

/**
 * @description:
 * @author: Mr.Huang
 * @create: 2019-09-06 10:48
 **/
public class UserAddress implements Serializable {
    private static final long serialVersionUID = 6249590902130727516L;

    private Integer id;
    /**
     * 用户地址
     */
    private String userAddress;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 收货人
     */
    private String consignee;
    /**
     * 用户电话号码
     */
    private String phoneNum;
    /**
     * 是否为默认地址 Y-是 N-否
     */
    private String isDefault;

    public UserAddress() {
        super();
    }

    public UserAddress(Integer id, String userAddress, String userId, String consignee, String phoneNum, String isDefault) {
        this.id = id;
        this.userAddress = userAddress;
        this.userId = userId;
        this.consignee = consignee;
        this.phoneNum = phoneNum;
        this.isDefault = isDefault;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "UserAddress{" + "id=" + id + ", userAddress='" + userAddress + '\'' + ", userId='" + userId + '\'' + ", consignee='" + consignee + '\'' + ", phoneNum='" + phoneNum + '\'' + ", isDefault='" + isDefault + '\'' + '}';
    }
}
