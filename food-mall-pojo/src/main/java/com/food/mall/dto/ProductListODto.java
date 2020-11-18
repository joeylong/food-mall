package com.food.mall.dto;

import lombok.Data;

@Data
public class ProductListODto {
    private String productId;
    private String productName;
    private int sellCounts;
    private String imgUrl;
    private int price;
}
