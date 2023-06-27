package com.xh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author 徐海
 * @DATE 2023/6/26 21:59
 * @Description:
 * @Version 1.01
 */
@Configuration  //声明配置类
@EnableSwagger2 //启用Swagger2
public class Swagger2Config {
    @Bean
    public Docket createRestAppi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //  com下所有API都交给Swagger2管理
                .apis(RequestHandlerSelectors.basePackage("com"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("贵民大新闻API")  //  标题
                .description("毕设你要我的命") //  描述
                .version("1.0")
                .build();
    }
}
