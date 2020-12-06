package com.treasuremountain.mango.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CORS配置
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/11/05 21:02
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /*
        允许跨域访问的路径
        允许跨域访问的源
        允许的请求方法
        预检间隔时间
        允许头部设置
        是否发送cookie
         */
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(168000)
                .allowedHeaders("*")
                .allowCredentials(true);
    }

}
