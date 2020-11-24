package com.food.mall.service;

import com.food.mall.dto.AddressIDto;
import com.food.mall.pojo.UserAddress;
import java.util.List;

public interface AddressService {
    //查询所有收货地址
    List<UserAddress> queryAll(String userId);

    //新增地址
    void addNewUserAddress(AddressIDto addressIDto);

    //用户修改地址
    void updateUserAddress(AddressIDto addressIDto);

    //根据用户id和地址id，删除对应的用户地址信息
    void deleteUserAddress(String userId, String addressId);

    //修改默认地址
    void updateUserAddressToBeDefault(String userId, String addressId);

    //根据用户id和地址id，查询具体的用户地址对象信息
    UserAddress queryUserAddress(String userId, String addressId);
}
