package com.apiplatform.bookstore.interceptors;

import com.apiplatform.bookstore.dtos.JwtClaimsDTO;
import com.apiplatform.bookstore.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtils jwtUtils;

    private JwtClaimsDTO jwtClaimsDTO;

    public JwtInterceptor(JwtClaimsDTO jwtClaimsDTO) {
        this.jwtClaimsDTO = jwtClaimsDTO;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(request.getRequestURI().contains("/user/login") || request.getRequestURI().contains("/user/signup"))) {
           Claims claims = jwtUtils.verifyJwt(request.getHeader("authorization"));

           jwtClaimsDTO.setId(claims.getId());
           jwtClaimsDTO.setUserName(claims.get("username").toString());
           jwtClaimsDTO.setId(claims.get("emailid").toString());
        }
        return true;
    }


}
