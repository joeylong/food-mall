package com.food.mall.service;

import com.food.mall.dto.CommentContentIDto;
import com.food.mall.dto.CommentContentODto;
import com.food.mall.pojo.Items;
import com.food.mall.pojo.ItemsImg;
import com.food.mall.pojo.ItemsParam;
import com.food.mall.pojo.ItemsSpec;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {
    /**
     * 根据商品ID查询详情
     *
     * @param productId
     * @return
     */
    Items queryProductById(String productId);

    /**
     * 根据商品id查询商品图片列表
     *
     * @param productId
     * @return
     */
    List<ItemsImg> queryProductImgList(String productId);

    /**
     * 根据商品id查询商品规格
     *
     * @param productId
     * @return
     */
    List<ItemsSpec> queryProductSpecList(String productId);

    /**
     * 根据商品id查询商品参数
     *
     * @param productId
     * @return
     */
    ItemsParam queryProductParam(String productId);

    /**
     * 根据商品id查询评论数
     *
     * @param productId
     * @return
     */
    int queryCommentLevel(String productId,Integer levelType);

    /**
     * 根据商品id查询评论数
     */
    PageInfo<CommentContentODto> queryCommentContent(CommentContentIDto contentIDto);
}
