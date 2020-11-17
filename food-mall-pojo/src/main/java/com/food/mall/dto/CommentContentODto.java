package com.food.mall.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentContentODto {
    private Integer commentLevel;
    private String content;
    private String specName;
    private Date createdTime;
    private String userFace;
    private String nickname;
}
