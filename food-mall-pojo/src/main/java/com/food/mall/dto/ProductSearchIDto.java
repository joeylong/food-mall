package com.food.mall.dto;

import lombok.Data;

@Data
public class ProductSearchIDto extends BaseDto{
    private String keywords;
    private String sort;
}
