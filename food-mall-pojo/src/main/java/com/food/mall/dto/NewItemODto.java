package com.food.mall.dto;

import lombok.Data;

import java.util.List;

@Data
public class NewItemODto {
    private Integer rootCatId;
    private String rootCatName;
    private String slogan;
    private String catImage;
    private String bgColor;
    private List<SimpleItemODto> simpleItemList;
}
