package com.food.mall.controller;

import com.food.mall.common.enums.YesOrNo;
import com.food.mall.common.utils.ResponseUtil;
import com.food.mall.common.utils.vo.ResponseVo;
import com.food.mall.pojo.Carousel;
import com.food.mall.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @GetMapping("/carousel")
    public ResponseVo carousel() {
        List<Carousel> list = carouselService.queryAll(YesOrNo.YES.type);
        return ResponseUtil.success(list);
    }

}
