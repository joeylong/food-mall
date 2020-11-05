package com.food.mall.controller;

import com.food.mall.common.utils.CookieUtils;
import com.food.mall.common.utils.JsonUtils;
import com.food.mall.common.utils.MD5Utils;
import com.food.mall.common.utils.ResponseUtil;
import com.food.mall.common.utils.vo.ResponseVo;
import com.food.mall.dto.UserIDto;
import com.food.mall.dto.UserODto;
import com.food.mall.pojo.Users;
import com.food.mall.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/usernameIsExist")
    public ResponseVo usernameIsExist(@RequestParam String username) {
        //用户名不能为空
        if(StringUtils.isBlank(username)){
            return ResponseUtil.error("用户名不能为空");
        }
        //查询用户是否存在
        boolean isExist = userService.queryUserNameIsExist(username);
        if(isExist){
            return ResponseUtil.error("用户名已存在");
        }
        //请求成功，用户名不存在
        return ResponseUtil.success();
    }

    @PostMapping("/register")
    public ResponseVo register(@Valid @RequestBody UserIDto userIDto){
        String username = userIDto.getUsername();
        String password = userIDto.getPassword();
        String confirmPassword = userIDto.getConfirmPassword();
        //查询用户是否存在
        boolean isExist = userService.queryUserNameIsExist(username);
        if(isExist){
            return ResponseUtil.error("用户名已存在");
        }
        //两次密码是否相同
        if(!password.equals(confirmPassword)){
            return ResponseUtil.error("两次密码不一致");
        }
        //注册
        Users user = userService.createUser(userIDto);
        return ResponseUtil.success(user);
    }

    @PostMapping("/login")
    public ResponseVo login(@RequestBody UserIDto userIDto,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        String username = userIDto.getUsername();
        String password = userIDto.getPassword();

        // 0. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password)) {
            return ResponseUtil.error("用户名或密码不能为空");
        }

        // 1. 实现登录
        Users userResult = userService.queryUserForLogin(username,
                MD5Utils.getMD5Str(password));

        if (userResult == null) {
            return ResponseUtil.error("用户名或密码不正确");
        }

        UserODto userODto = new UserODto();
        BeanUtils.copyProperties(userResult,userODto);

        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userODto), true);

        // TODO 生成用户token，存入redis会话
        // TODO 同步购物车数据

        return ResponseUtil.success(userODto);
    }

    @PostMapping("/logout")
    public ResponseVo logout(@RequestParam String userId,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        //清除会话cookie
        CookieUtils.deleteCookie(request,response,"user");
        //TODO 分布式会话中需要清除用户数据

        return ResponseUtil.success();
    }
}
