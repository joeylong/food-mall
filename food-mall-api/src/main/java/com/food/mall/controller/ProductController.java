package com.food.mall.controller;

import com.food.mall.common.utils.ResponseUtil;
import com.food.mall.common.utils.vo.ResponseVo;
import com.food.mall.dto.ProductInfoODto;
import com.food.mall.service.ProductService;
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
}
