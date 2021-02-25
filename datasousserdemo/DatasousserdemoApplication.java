package com.example.datasousserdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.datasousserdemo.mapper")
public class DatasousserdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatasousserdemoApplication.class, args);
    }

}
