package com.food.mall.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserIDto {

    @NotNull(message = "用户名不能为空")
    private String username;

    @Size(min = 6,message = "密码不能少于6位")
    private String password;

    @NotNull(message = "确认密码不能为空")
    private String confirmPassword;
}
