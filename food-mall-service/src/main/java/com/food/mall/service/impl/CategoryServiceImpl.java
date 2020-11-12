package com.food.mall.service.impl;

import com.food.mall.common.enums.CategoryEnum;
import com.food.mall.dto.CategoryODto;
import com.food.mall.dto.NewItemODto;
import com.food.mall.mapper.CategoryMapper;
import com.food.mall.pojo.Category;
import com.food.mall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryCategoryByType(Integer type) {
        Example example = new Example(Category.class);
        example.createCriteria().andEqualTo("type",type);
        return categoryMapper.selectByExample(example);
    }

    @Override
    public List<CategoryODto> getSubCatList(Integer rootCatId) {
        //获取二级类别
        List<CategoryODto> twoCategoryODtoList = getSubCatListByFatherId(rootCatId);
        for(CategoryODto twoCategoryODto : twoCategoryODtoList){
            List<CategoryODto> categoryODtoChildList = getChildCategory(twoCategoryODto.getId());
            twoCategoryODto.setSubCatList(categoryODtoChildList);
        }
        return twoCategoryODtoList;
    }

    @Override
    public List<CategoryODto> getSubCatListByFatherId(Integer fatherId) {
        Example example = new Example(Category.class);
        example.createCriteria().andEqualTo("fatherId",fatherId).andNotEqualTo("type",CategoryEnum.ROOT.type);
        List<Category> childCategoryList = categoryMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(childCategoryList)){
            return null;
        }
        return childCategoryList.stream().map(Category::category2CategoryODto).collect(Collectors.toList());
    }

    @Override
    public List<NewItemODto> getSixNewItemList(Integer rootCatId) {
        return categoryMapper.getSixNewItemList(rootCatId);
    }

    private List<CategoryODto> getChildCategory(Integer fatherId){
        if(fatherId == null){
            return null;
        }
        List<CategoryODto> childCategoryODtoList = getSubCatListByFatherId(fatherId);
        if(CollectionUtils.isEmpty(childCategoryODtoList)){
            return new ArrayList<>();
        }
        for(CategoryODto childCategoryODto :childCategoryODtoList){
            childCategoryODto.setSubCatList(getChildCategory(childCategoryODto.getId()));
        }
        return childCategoryODtoList;
    }
}
