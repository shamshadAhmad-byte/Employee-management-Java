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
import jakarta.servlet.http.HttpServletResponse;

@Component 
@Order(2)
public class AuthenticateFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException{

                HttpServletRequest req = (HttpServletRequest) request;

                String token = req.getHeader("Authorization");

                if (token == null) {
                    HttpServletResponse res = (HttpServletResponse) response;

                    res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    res.getWriter().write("Authorization required");

                    return; // DispatcherServlet will NOT be called
                }

                chain.doFilter(request, response);
            }
}
