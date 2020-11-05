package com.food.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.food.mall.mapper")
@ComponentScan(basePackages = {"com.food.mall","org.n3r.idworker"})
public class FoodMallApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodMallApiApplication.class, args);
    }

}
