package com.food.mall.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ShopCartIDto {
    @NotNull(message = "用户id不能为空")
    private String userId;
    private String itemId;
    private String itemImgUrl;
    private String itemName;
    private String specId;
    private String specName;
    private Integer buyCounts;
    private String priceDiscount;
    private String priceNormal;
}
