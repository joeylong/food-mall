package com.food.mall.service.impl;

import com.food.mall.common.utils.DesensitizationUtil;
import com.food.mall.dto.*;
import com.food.mall.mapper.*;
import com.food.mall.pojo.*;
import com.food.mall.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private ItemsCommentsMapper productCommentMapper;

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

    @Override
    public int queryCommentLevel(String productId, Integer levelType) {
        Example itemsCommentExp = new Example(ItemsComments.class);
        Example.Criteria criteria = itemsCommentExp.createCriteria();
        criteria.andEqualTo("itemId", productId);
        if(StringUtils.isNotBlank(productId)){
            criteria.andEqualTo("commentLevel",levelType);
        }
        return productCommentMapper.selectCountByExample(itemsCommentExp);
    }

    @Override
    public PageInfo<CommentContentODto> queryCommentContent(CommentContentIDto contentIDto) {
        PageHelper.startPage(contentIDto.getPage(),contentIDto.getPageSize());
        List<CommentContentODto> list =productCommentMapper.queryCommentContent(contentIDto);
        list.forEach(l->{
            l.setNickname(DesensitizationUtil.commonDisplay(l.getNickname()));
        });
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<ProductListODto> searchProductList(ProductSearchIDto searchIDto) {
        PageHelper.startPage(searchIDto.getPage(),searchIDto.getPageSize());
        List<ProductListODto> list =productMapper.searchProductList(searchIDto);
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<ProductListODto> searchCatProductList(CatProductSearchIDto searchIDto) {
        PageHelper.startPage(searchIDto.getPage(),searchIDto.getPageSize());
        List<ProductListODto> list =productMapper.searchCatProductList(searchIDto);
        return new PageInfo<>(list);
    }
}
