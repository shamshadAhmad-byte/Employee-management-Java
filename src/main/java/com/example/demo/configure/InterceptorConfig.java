package com.example.demo.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.filter.LogInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

     
    private final LogInterceptor logInterceptor;
    public InterceptorConfig(LogInterceptor logInterceptor) {
        this.logInterceptor = logInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor).addPathPatterns("/api/department");
    }

}
