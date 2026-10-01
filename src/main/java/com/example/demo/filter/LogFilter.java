package com.example.demo.filter;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component 
@Order(1)
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException{

                HttpServletRequest httpRequest = (HttpServletRequest) request;
                System.out.println("Request URL: " + httpRequest.getRequestURL());
                System.out.println("Request Method: " + httpRequest.getMethod());

                System.out.println("Request received at: " + System.currentTimeMillis());
                System.out.println("Request successfully processed");
                chain.doFilter(request, response);
            }
}
