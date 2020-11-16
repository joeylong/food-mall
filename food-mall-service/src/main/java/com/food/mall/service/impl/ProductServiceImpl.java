package com.food.mall.service.impl;

import com.food.mall.mapper.ItemsImgMapper;
import com.food.mall.mapper.ItemsMapper;
import com.food.mall.mapper.ItemsParamMapper;
import com.food.mall.mapper.ItemsSpecMapper;
import com.food.mall.pojo.Items;
import com.food.mall.pojo.ItemsImg;
import com.food.mall.pojo.ItemsParam;
import com.food.mall.pojo.ItemsSpec;
import com.food.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ItemsMapper productMapper;

    @Autowired
    private ItemsImgMapper productImgMapper;

    @Autowired
    private ItemsSpecMapper productSpecMapper;

    @Autowired
    private ItemsParamMapper productParamMapper;

    @Override
    public Items queryProductById(String productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<ItemsImg> queryProductImgList(String productId) {
        Example itemsImgExp = new Example(ItemsImg.class);
        Example.Criteria criteria = itemsImgExp.createCriteria();
        criteria.andEqualTo("itemId", productId);
        return productImgMapper.selectByExample(itemsImgExp);
    }

    @Override
    public List<ItemsSpec> queryProductSpecList(String productId) {
        Example itemsSpecExp = new Example(ItemsSpec.class);
        Example.Criteria criteria = itemsSpecExp.createCriteria();
        criteria.andEqualTo("itemId", productId);
        return productSpecMapper.selectByExample(itemsSpecExp);
    }

    @Override
    public ItemsParam queryProductParam(String productId) {
        Example itemsParamExp = new Example(ItemsParam.class);
        Example.Criteria criteria = itemsParamExp.createCriteria();
        criteria.andEqualTo("itemId", productId);
        return productParamMapper.selectOneByExample(itemsParamExp);
    }
}
