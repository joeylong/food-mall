package com.food.mall.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
public class AddressIDto {
    private String addressId;
    private String userId;

    @NotNull(message = "收货人不能为空")
    @Max(value = 12,message = "收货人姓名不能太长")
    private String receiver;

    @NotNull(message = "收货人手机号不能为空")
    @Max(value = 11,message = "收货人手机号长度不正确")
    private String mobile;

    @NotNull(message = "省份不能为空")
    private String province;

    @NotNull(message = "城市不能为空")
    private String city;

    @NotNull(message = "区县不能为空")
    private String district;

    @NotNull(message = "详细地址不能为空")
    private String detail;
}
