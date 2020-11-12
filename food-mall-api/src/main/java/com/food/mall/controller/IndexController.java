package com.food.mall.controller;

import com.food.mall.common.enums.CategoryEnum;
import com.food.mall.common.enums.YesOrNoEnum;
import com.food.mall.common.utils.ResponseUtil;
import com.food.mall.common.utils.vo.ResponseVo;
import com.food.mall.dto.CategoryODto;
import com.food.mall.dto.NewItemODto;
import com.food.mall.pojo.Carousel;
import com.food.mall.pojo.Category;
import com.food.mall.service.CarouselService;
import com.food.mall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/carousel")
    public ResponseVo carousel() {
        List<Carousel> list = carouselService.queryAll(YesOrNoEnum.YES.type);
        return ResponseUtil.success(list);
    }

    @GetMapping("/cats")
    public ResponseVo cats() {
        List<Category> list = categoryService.queryCategoryByType(CategoryEnum.ROOT.type);
        return ResponseUtil.success(list);
    }

    @GetMapping("/subCat/{rootCatId}")
    public ResponseVo subCat(@PathVariable Integer rootCatId) {
        if (rootCatId == null) {
            return ResponseUtil.error("分类不存在");
        }
        List<CategoryODto>  list = categoryService.getSubCatList(rootCatId);
        return ResponseUtil.success(list);
    }

    @GetMapping("/sixNewItems/{rootCatId}")
    public ResponseVo sixNewItems(@PathVariable Integer rootCatId) {
        if (rootCatId == null) {
            return ResponseUtil.error("分类不存在");
        }
        List<NewItemODto>  list = categoryService.getSixNewItemList(rootCatId);
        return ResponseUtil.success(list);
    }

}
