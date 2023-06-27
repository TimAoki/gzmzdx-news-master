package com.xh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 徐海
 * @DATE 2023/6/27 15:36
 * @Description:
 * @Version 1.01
 */
/*
 *   跨域配置类
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //允许跨域访问的路径
                .allowedOriginPatterns("*") //允许跨域访问的资源
                // allowedOrigins 报错的话改为 allowedOriginPatterns
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE") //允许请求方法
                .maxAge(168000) //预检间隔时间
                .allowedHeaders("*")    //允许头部设置
                .allowCredentials(true); //是否发送cookie
    }
}
