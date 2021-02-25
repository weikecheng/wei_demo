package com.example.datasousserdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.datasousserdemo.conf.DB1Config;
import com.example.datasousserdemo.conf.DB2Config;


@SpringBootApplication
@EnableConfigurationProperties(value = {DB2Config.class, DB1Config.class})

public class DatasousserdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatasousserdemoApplication.class, args);
    }

}
