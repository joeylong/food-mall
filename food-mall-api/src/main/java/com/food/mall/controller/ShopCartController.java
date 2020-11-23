package com.food.mall.controller;

import com.food.mall.common.utils.ResponseUtil;
import com.food.mall.common.utils.vo.ResponseVo;
import com.food.mall.dto.ShopCartIDto;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/shopCart")
@RestController
public class ShopCartController {

    @PostMapping("/add")
    public ResponseVo add(@RequestBody ShopCartIDto shopCartIDto,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        //TODO同步到redis
        return ResponseUtil.success();
    }
}
