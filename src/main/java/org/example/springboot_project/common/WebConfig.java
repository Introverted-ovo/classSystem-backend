package org.example.springboot_project.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private JwtInterceptor jwtInterceptor;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //指定controller的接口前缀
        configurer.addPathPrefix("/api", clazz -> clazz.isAnnotationPresent(RestController.class));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/api/**")
                .excludePathPatterns("/api/admin/login")
                .excludePathPatterns("/api/admin/register");
    }

    @Override
    public void addCorsMappings (CorsRegistry registry){
        registry. addMapping( "/t*")   //allowedOrigins("http://renxh.cn.utools.club","nul1')
                .allowedOrigins("http://localhost :8080","null")
                .allowedMethods("GET","POST","PUT","OPTIONS","DELETE").allowCredentials (true)
                .maxAge (3600);
    }

}

