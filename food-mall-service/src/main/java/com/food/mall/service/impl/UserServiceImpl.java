package com.food.mall.service.impl;

import com.food.mall.common.enums.SexEnum;
import com.food.mall.common.utils.DateUtil;
import com.food.mall.common.utils.MD5Utils;
import com.food.mall.dto.UserIDto;
import com.food.mall.mapper.UsersMapper;
import com.food.mall.pojo.Users;
import com.food.mall.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private static final String USER_FACE = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603209543607&di=7169c516cb25f457a0c2664ddcb71798&imgtype=0&src=http%3A%2F%2Falcdn.img.xiaoka.tv%2F20161019%2F7e9%2F304%2F34561699%2F7e930479e72e9d3c31e8cdebfa4668e3.jpg%401e_1c_0o_0l_640h_640w_90q_1pr.jpg";

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    @Override
    public boolean queryUserNameIsExist(String username) {
        Example userExample = new Example(Users.class);
        userExample.createCriteria().andEqualTo("username",username);
        Users user = usersMapper.selectOneByExample(userExample);
        return user != null;
    }

    @Override
    public Users createUser(UserIDto userIDto) {
        Users user = new Users();
        user.setId(sid.nextShort());
        user.setUsername(userIDto.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userIDto.getPassword()));
        } catch (Exception e) {
            log.error("创建用户失败:{}",e);
        }
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));
        user.setNickname(userIDto.getUsername());
        user.setSex(SexEnum.SECRET.type);
        user.setFace(USER_FACE);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        usersMapper.insert(user);
        return user;
    }

    @Override
    public Users queryUserForLogin(String username, String password) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username", username);
        userCriteria.andEqualTo("password", password);

        return usersMapper.selectOneByExample(userExample);

    }

}
