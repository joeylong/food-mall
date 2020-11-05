package com.food.mall.service;

import com.food.mall.dto.UserIDto;
import com.food.mall.pojo.Users;

public interface UserService {
    /**
     * 判断用户名是否存在
     */
    boolean queryUserNameIsExist(String userName);
    /**
     * 创建用户
     */
    Users createUser(UserIDto userIDto);
    /**
     * 检索用户名和密码是否匹配，用于登录
     */
    Users queryUserForLogin(String username, String password);
}
