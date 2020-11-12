package com.food.mall.mapper;

import com.food.mall.dto.NewItemODto;
import com.food.mall.pojo.Category;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<Category> {

    List<NewItemODto> getSixNewItemList(Integer rootCatId);

}