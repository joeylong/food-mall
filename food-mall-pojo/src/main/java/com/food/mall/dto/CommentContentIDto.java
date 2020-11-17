package com.food.mall.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CommentContentIDto extends BaseDto{
    @NotNull(message = "商品id不能为空")
    private String productId;
    @NotNull(message = "商品评论等级不能为空")
    private Integer level;
}
