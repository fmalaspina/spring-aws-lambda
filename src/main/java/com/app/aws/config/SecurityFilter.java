package com.app.aws.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Map;

public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var token = ((HttpServletRequest)servletRequest).getHeader("token");
        if (token == null || !token.equals("1234")) {
            servletResponse.setContentType("application/json");
            servletResponse.setCharacterEncoding("UTF-8");
            ((HttpServletResponse) servletResponse).setStatus(401);

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode objectNode = objectMapper.createObjectNode();
            objectNode.put("error", "Invalid token");
            servletResponse.getOutputStream().write(objectMapper.writeValueAsBytes(objectNode));
            servletResponse.flushBuffer();
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
