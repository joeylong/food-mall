package com.food.mall.common.utils;


import com.food.mall.common.utils.vo.ResponseVo;

public class ResponseUtil {

    public static ResponseVo success(Object object){
        ResponseVo responseVo = new ResponseVo();
        responseVo.setCode(200);
        responseVo.setData(object);
        responseVo.setMsg("成功");
        return responseVo;
    }

    public static ResponseVo success(){
        return success(null);
    }

    public static ResponseVo error(Integer code,String msg){
        ResponseVo responseVo = new ResponseVo();
        responseVo.setCode(code);
        responseVo.setMsg(msg);
        return responseVo;

    }

    public static ResponseVo error(String msg){
        ResponseVo responseVo = new ResponseVo();
        responseVo.setCode(500);
        responseVo.setMsg(msg);
        return responseVo;

    }

}
