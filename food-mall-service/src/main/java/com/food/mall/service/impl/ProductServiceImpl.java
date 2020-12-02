package com.food.mall.service.impl;

import com.food.mall.common.enums.YesOrNoEnum;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<ShopCartODto> queryItemsBySpecIds(String specIds) {
        if(StringUtils.isBlank(specIds)){
            return new ArrayList<>();
        }
        String[] ids = specIds.split(",");
        List<String> specIdList = Arrays.asList(ids);
        return productMapper.queryItemsBySpecIds(specIdList);
    }

    @Override
    public ItemsSpec queryItemSpecById(String specId) {
        return productSpecMapper.selectByPrimaryKey(specId);
    }

    @Override
    public String queryItemMainImgById(String itemId) {
        ItemsImg itemsImg = new ItemsImg();
        itemsImg.setItemId(itemId);
        itemsImg.setIsMain(YesOrNoEnum.YES.type);
        ItemsImg result = productImgMapper.selectOne(itemsImg);
        return Optional.ofNullable(result).map(ItemsImg :: getUrl).orElse("");
    }

    @Override
    public void decreaseItemSpecStock(String specId, int buyCounts) {
        // synchronized 不推荐使用，集群下无用，性能低下
        // 锁数据库: 不推荐，导致数据库性能低下
        // 分布式锁 zookeeper redis

        // lockUtil.getLock(); -- 加锁

        // 1. 查询库存
        //        int stock = 10;

        // 2. 判断库存，是否能够减少到0以下
        //        if (stock - buyCounts < 0) {
        // 提示用户库存不够
        //            10 - 3 -3 - 5 = -1
        //        }

        // lockUtil.unLock(); -- 解锁


        int result = productMapper.decreaseItemSpecStock(specId, buyCounts);
        if (result != 1) {
            throw new RuntimeException("订单创建失败，原因：库存不足!");
        }
    }
}
