package com.food.mall.dto;

import com.food.mall.pojo.Items;
import com.food.mall.pojo.ItemsImg;
import com.food.mall.pojo.ItemsParam;
import com.food.mall.pojo.ItemsSpec;
import lombok.Data;

import java.util.List;

@Data
public class ProductInfoODto {
    private Items product;
    private List<ItemsImg> productImgList;
    private List<ItemsSpec> productSpecList;
    private ItemsParam productParams;
}
