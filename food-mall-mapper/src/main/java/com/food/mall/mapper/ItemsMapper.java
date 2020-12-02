package com.food.mall.mapper;

import com.food.mall.dto.CatProductSearchIDto;
import com.food.mall.dto.ProductListODto;
import com.food.mall.dto.ProductSearchIDto;
import com.food.mall.dto.ShopCartODto;
import com.food.mall.pojo.Items;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ItemsMapper extends Mapper<Items> {
    List<ProductListODto> searchProductList(ProductSearchIDto searchProductIDto);
    List<ProductListODto> searchCatProductList(CatProductSearchIDto searchProductIDto);
    List<ShopCartODto> queryItemsBySpecIds(@Param("specIds")List specIds);
    int decreaseItemSpecStock(@Param("specId") String specId,
                                     @Param("pendingCounts") int pendingCounts);
}