package com.food.mall.controller;

import com.food.mall.common.enums.CommentLevelTypeEnum;
import com.food.mall.common.utils.ResponseUtil;
import com.food.mall.common.utils.vo.ResponseVo;
import com.food.mall.dto.*;
import com.food.mall.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/info/{productId}")
    public ResponseVo usernameIsExist(@PathVariable String productId) {
        ProductInfoODto productInfo = new ProductInfoODto();
        productInfo.setProduct(productService.queryProductById(productId));
        productInfo.setProductImgList(productService.queryProductImgList(productId));
        productInfo.setProductSpecList(productService.queryProductSpecList(productId));
        productInfo.setProductParams(productService.queryProductParam(productId));
        return ResponseUtil.success(productInfo);
    }
    @GetMapping("/commentLevel")
    public ResponseVo commentLevel(String productId) {
        CommentLevelCountsODto countsODto = new CommentLevelCountsODto();
        countsODto.setGoodCounts(productService.queryCommentLevel(productId, CommentLevelTypeEnum.GOOD.type));
        countsODto.setNormalCounts(productService.queryCommentLevel(productId, CommentLevelTypeEnum.NORMAL.type));
        countsODto.setBadCounts(productService.queryCommentLevel(productId, CommentLevelTypeEnum.BAD.type));
        countsODto.setTotalCounts(productService.queryCommentLevel(productId, null));
        return ResponseUtil.success(countsODto);
    }

    @GetMapping("/comments")
    public ResponseVo comments(CommentContentIDto contentIDto) {
        PageInfo pageInfo = productService.queryCommentContent(contentIDto);
        return ResponseUtil.success(pageInfo);
    }

    @GetMapping("/search")
    public ResponseVo searchProductList(ProductSearchIDto searchIDto) {
        PageInfo pageInfo = productService.searchProductList(searchIDto);
        return ResponseUtil.success(pageInfo);
    }

    @GetMapping("/catProduct")
    public ResponseVo catProduct(CatProductSearchIDto searchIDto) {
        PageInfo pageInfo = productService.searchCatProductList(searchIDto);
        return ResponseUtil.success(pageInfo);
    }


}
