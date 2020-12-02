package com.food.mall.service;


import com.food.mall.dto.OrderCreateIDto;
import com.food.mall.dto.OrderCreateODto;

public interface OrderService {
    /**
     * 创建订单
     */
     OrderCreateODto createOrder(OrderCreateIDto orderCreateiDto);
}
