package com.food.mall.mapper;

import com.food.mall.dto.CommentContentIDto;
import com.food.mall.dto.CommentContentODto;
import com.food.mall.pojo.ItemsComments;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ItemsCommentsMapper extends Mapper<ItemsComments> {
    List<CommentContentODto> queryCommentContent(CommentContentIDto contentIDto);
}