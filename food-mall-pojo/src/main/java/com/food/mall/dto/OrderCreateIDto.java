package com.food.mall.dto;

import lombok.Data;

@Data
public class OrderCreateIDto {
    private String userId;
    private String productSpecIds;
    private String addressId;
    private Integer payMethod;
    private String leftMsg;
}
