package com.example.demo.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component 
public class LogInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LogInterceptor: preHandle method called");
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LogInterceptor: afterCompletion method called");
        Long startTime = (Long) request.getAttribute("startTime");
        Long endTime =System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms taken to process the request");
    }
}
