package com.food.mall.service;

import com.food.mall.pojo.Items;
import com.food.mall.pojo.ItemsImg;
import com.food.mall.pojo.ItemsParam;
import com.food.mall.pojo.ItemsSpec;

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
}
