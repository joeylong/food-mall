package com.food.mall.dto;

import lombok.Data;

@Data
public class OrderCreateODto {
    private String orderId;
    private MerchantOrdersODto merchantOrdersVO;
}
