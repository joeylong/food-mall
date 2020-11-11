package com.food.mall.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryODto {
    private Integer id;
    private String name;
    private String type;
    private Integer fatherId;
    private List<CategoryODto> subCatList;
}
