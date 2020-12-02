package com.food.mall.service.impl;

import com.food.mall.common.enums.OrderStatusEnum;
import com.food.mall.common.enums.YesOrNoEnum;
import com.food.mall.dto.OrderCreateIDto;
import com.food.mall.dto.OrderCreateODto;
import com.food.mall.mapper.OrderItemsMapper;
import com.food.mall.mapper.OrderStatusMapper;
import com.food.mall.mapper.OrdersMapper;
import com.food.mall.pojo.*;
import com.food.mall.service.AddressService;
import com.food.mall.service.OrderService;
import com.food.mall.service.ProductService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {



    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderItemsMapper orderItemsMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderStatusMapper orderStatusMapper;



    @Autowired
    private Sid sid;

    @Override
    public OrderCreateODto createOrder(OrderCreateIDto orderCreateiDto) {
        //获取收获地址
        UserAddress userAddress = addressService.queryUserAddress(orderCreateiDto.getUserId(),orderCreateiDto.getAddressId());
        //新订单数据保存
        String orderId = sid.nextShort();
        Orders newOrder = new Orders();
        newOrder.setId(orderId);
        newOrder.setUserId(orderCreateiDto.getUserId());
        newOrder.setReceiverMobile(userAddress.getMobile());
        newOrder.setReceiverName(userAddress.getReceiver());
        newOrder.setReceiverAddress(userAddress.getProvince()+" "
                                    +userAddress.getCity()+" "
                                    +userAddress.getDistrict()+" "
                                    +userAddress.getDetail());
        newOrder.setPostAmount(0);
        newOrder.setPayMethod(orderCreateiDto.getPayMethod());
        newOrder.setLeftMsg(orderCreateiDto.getLeftMsg());
        newOrder.setIsComment(YesOrNoEnum.NO.type);
        newOrder.setIsDelete(YesOrNoEnum.NO.type);
        newOrder.setCreatedTime(new Date());
        newOrder.setUpdatedTime(new Date());

        // 2. 循环根据itemSpecIds保存订单商品信息表
        String[] itemSpecIdArr = orderCreateiDto.getProductSpecIds().split(",");
        int totalAmount = 0;    // 商品原价累计
        int realPayAmount = 0;  // 优惠后的实际支付价格累计
        for (String itemSpecId : itemSpecIdArr) {

            // TODO 整合redis后，商品购买的数量重新从redis的购物车中获取
            int buyCounts = 1;

            // 2.1 根据规格id，查询规格的具体信息，主要获取价格
            ItemsSpec itemSpec = productService.queryItemSpecById(itemSpecId);
            totalAmount += itemSpec.getPriceNormal() * buyCounts;
            realPayAmount += itemSpec.getPriceDiscount() * buyCounts;

            // 2.2 根据商品id，获得商品信息以及商品图片
            String itemId = itemSpec.getItemId();
            Items item = productService.queryProductById(itemId);
            String imgUrl = productService.queryItemMainImgById(itemId);

            // 2.3 循环保存子订单数据到数据库
            String subOrderId = sid.nextShort();
            OrderItems subOrderItem = new OrderItems();
            subOrderItem.setId(subOrderId);
            subOrderItem.setOrderId(orderId);
            subOrderItem.setItemId(itemId);
            subOrderItem.setItemName(item.getItemName());
            subOrderItem.setItemImg(imgUrl);
            subOrderItem.setBuyCounts(buyCounts);
            subOrderItem.setItemSpecId(itemSpecId);
            subOrderItem.setItemSpecName(itemSpec.getName());
            subOrderItem.setPrice(itemSpec.getPriceDiscount());
            orderItemsMapper.insert(subOrderItem);

            // 2.4 在用户提交订单以后，规格表中需要扣除库存
            productService.decreaseItemSpecStock(itemSpecId, buyCounts);
        }

        newOrder.setTotalAmount(totalAmount);
        newOrder.setRealPayAmount(realPayAmount);
        ordersMapper.insert(newOrder);
        // 3. 保存订单状态表
        OrderStatus waitPayOrderStatus = new OrderStatus();
        waitPayOrderStatus.setOrderId(orderId);
        waitPayOrderStatus.setOrderStatus(OrderStatusEnum.WAIT_PAY.type);
        waitPayOrderStatus.setCreatedTime(new Date());
        orderStatusMapper.insert(waitPayOrderStatus);
        return null;
    }
}
