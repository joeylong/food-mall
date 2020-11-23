package com.food.mall.dto;

import lombok.Data;

@Data
public class ShopCartODto {
    private String itemId;
    private String itemImgUrl;
    private String itemName;
    private String specId;
    private String specName;
    private String priceDiscount;
    private String priceNormal;
}
