package com.blog_system.config;

import com.blog_system.interceptor.LogInInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * 拦截器配置项
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final List excludes = Arrays.asList(
            "/**/*.html",
            "/blog-editormd/**",
            "/css/**",
            "/js/**",
            "/pic/**",
            "/user/login"
    );

    @Autowired
    private LogInInterceptor logInInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludes);
    }


}
