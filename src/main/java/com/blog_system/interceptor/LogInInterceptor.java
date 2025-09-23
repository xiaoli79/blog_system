package com.blog_system.interceptor;


import com.blog_system.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//设置拦截器
@Slf4j
@Component
public class LogInInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("user_token_header");
        log.info("从header中获取token:{}",token);
        Claims claims = JwtUtils.parseToken(token);
        if(claims == null){
            response.setStatus(401);
            return false;
        }
        return true;
    }
}
