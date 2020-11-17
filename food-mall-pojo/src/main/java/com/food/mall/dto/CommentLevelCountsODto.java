package com.food.mall.dto;

import lombok.Data;

@Data
public class CommentLevelCountsODto {
    public int totalCounts;
    public int goodCounts;
    public int normalCounts;
    public int badCounts;
}
