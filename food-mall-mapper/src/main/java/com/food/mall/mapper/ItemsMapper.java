package com.food.mall.mapper;

import com.food.mall.dto.CatProductSearchIDto;
import com.food.mall.dto.ProductListODto;
import com.food.mall.dto.ProductSearchIDto;
import com.food.mall.pojo.Items;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ItemsMapper extends Mapper<Items> {
    List<ProductListODto> searchProductList(ProductSearchIDto searchProductIDto);
    List<ProductListODto> searchCatProductList(CatProductSearchIDto searchProductIDto);
}