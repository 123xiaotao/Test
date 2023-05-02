package com.atguigu.servicecms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@MapperScan(basePackages = {"com.atguigu.servicecms/mapper"})
public class CodApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodApplication.class, args);
    }
}
