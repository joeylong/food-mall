package com.food.mall.service;

import com.food.mall.dto.*;
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

    /**
     * 商品检索
     */
    PageInfo<ProductListODto> searchProductList(ProductSearchIDto searchIDto);

    /**
     * 商根据类别id品检索
     */
    PageInfo<ProductListODto> searchCatProductList(CatProductSearchIDto searchIDto);

    /**
     * 刷新购物车中的数据
     */
    List<ShopCartODto> queryItemsBySpecIds(String specIds);
    /**
     * 根据商品规格id获取规格对象的具体信息
     * @param specId
     * @return
     */
    ItemsSpec queryItemSpecById(String specId);

    /**
     * 根据商品id获得商品图片主图url
     * @param itemId
     * @return
     */
    String queryItemMainImgById(String itemId);

    /**
     * 减少库存
     * @param specId
     * @param buyCounts
     */
    void decreaseItemSpecStock(String specId, int buyCounts);


}
