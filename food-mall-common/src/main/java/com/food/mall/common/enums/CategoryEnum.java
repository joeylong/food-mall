package com.food.mall.common.enums;

public enum CategoryEnum {
    ROOT(1, "一级类别"),
    TWO(2, "二级类别"),
    THREE(3, "三级类别");

    public final Integer type;
    public final String value;

    CategoryEnum(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
