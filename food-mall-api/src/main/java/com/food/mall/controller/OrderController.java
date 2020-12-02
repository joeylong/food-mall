package com.food.mall.controller;

import com.food.mall.common.utils.ResponseUtil;
import com.food.mall.common.utils.vo.ResponseVo;
import com.food.mall.dto.AddressIDto;
import com.food.mall.dto.OrderCreateIDto;
import com.food.mall.pojo.UserAddress;
import com.food.mall.service.AddressService;
import com.food.mall.service.OrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseVo createOrder(@RequestBody OrderCreateIDto orderCreateIDto) {
        //创建订单
        orderService.createOrder(orderCreateIDto);
        // 2. 创建订单以后，移除购物车中已结算（已提交）的商品
        //3. 向支付中心发送当前订单，用于保存支付中心的订单数据
        return ResponseUtil.success();
    }

}
