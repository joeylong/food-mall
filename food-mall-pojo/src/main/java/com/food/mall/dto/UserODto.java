package com.food.mall.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserODto {

    private String id;

    private String username;

    private String nickname;

    private String face;
}
