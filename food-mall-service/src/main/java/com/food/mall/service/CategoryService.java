package com.food.mall.service;


import com.food.mall.dto.CategoryODto;
import com.food.mall.pojo.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 查询所有主类别
     * @return
     */
    List<Category> queryCategoryByType(Integer type);

    /**
     * 根据rootId递归获取子类别
     * @return
     */
    List<CategoryODto> getSubCatList(Integer rootCatId);

    /**
     * 根据fatherId获取类别
     *
     */
    List<CategoryODto> getSubCatListByFatherId(Integer fatherId);
}
