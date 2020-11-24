package com.food.mall.controller;

import com.food.mall.common.utils.ResponseUtil;
import com.food.mall.common.utils.vo.ResponseVo;
import com.food.mall.dto.AddressIDto;
import com.food.mall.pojo.UserAddress;
import com.food.mall.service.AddressService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    public ResponseVo list(@RequestParam("userId") String userId) {
        List<UserAddress> list = addressService.queryAll(userId);
        return ResponseUtil.success(list);
    }

    @PostMapping("/add")
    public ResponseVo add(@RequestBody AddressIDto addressIDto) {
        addressService.addNewUserAddress(addressIDto);
        return ResponseUtil.success();
    }

    @PostMapping("/update")
    public ResponseVo update(@RequestBody AddressIDto addressIDto) {

        if (StringUtils.isBlank(addressIDto.getAddressId())) {
            return ResponseUtil.error("修改地址错误：addressId不能为空");
        }

        addressService.updateUserAddress(addressIDto);

        return ResponseUtil.success();
    }

    @PostMapping("/delete")
    public ResponseVo delete(
            @RequestParam String userId,
            @RequestParam String addressId) {

        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return ResponseUtil.error("删除地址错误：addressId或userId不能为空");
        }
        addressService.deleteUserAddress(userId, addressId);
        return ResponseUtil.success();
    }


    @PostMapping("/setDefault")
    public ResponseVo setDefault(
            @RequestParam String userId,
            @RequestParam String addressId) {

        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return ResponseUtil.error("设置默认地址错误：addressId或userId不能为空");
        }
        addressService.updateUserAddressToBeDefault(userId, addressId);
        return ResponseUtil.success();
    }

}
