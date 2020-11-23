package com.food.mall.controller;

import com.food.mall.common.utils.ResponseUtil;
import com.food.mall.common.utils.vo.ResponseVo;
import com.food.mall.dto.ShopCartIDto;
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
        // TODO 同步到redis
        return ResponseUtil.success();
    }

    @PostMapping("/del")
    public ResponseVo del(@RequestParam("userId") String userId,@RequestParam("productSpecId")String productSpecId) {
        // TODO 同步到redis
        return ResponseUtil.success();
    }
}
