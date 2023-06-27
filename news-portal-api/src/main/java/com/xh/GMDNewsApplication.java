package com.xh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author 徐海
 * @DATE 2023/6/269:15
 * @Description:
 * @Version 1.01
 */
@SpringBootApplication
@MapperScan("com.xh.mapper")
public class GMDNewsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GMDNewsApplication.class, args);
    }
}
