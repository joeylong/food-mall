package com.food.mall.dto;

import lombok.Data;

@Data
public class CatProductSearchIDto extends BaseDto{
    private Integer catId;
    private String sort;
}
