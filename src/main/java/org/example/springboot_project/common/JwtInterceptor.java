package org.example.springboot_project.common;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.example.springboot_project.entity.Admin;
import org.example.springboot_project.exception.CustomException;
import org.example.springboot_project.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//jwt拦截器
@Component
public class JwtInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(JwtInterceptor.class);

    @Resource
    private AdminService adminService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String token =request.getHeader("token");
        if(StrUtil.isBlank(token)) {
            token = request.getParameter("token");
        }
        if(StrUtil.isBlank(token)) {
            throw new CustomException("无token，请重新登录");
        }

        String adminId;
        Admin admin;
        try {
            adminId = JWT.decode(token).getAudience().get(0);
            admin = adminService.findById(Integer.parseInt(adminId));
        } catch (Exception e) {
            String errMsg = "token验证失败，请重新登录";
            log.error(errMsg + ", token=" + token,e);
            throw new CustomException(errMsg);
        }
        if(admin == null) {
            throw new CustomException("用户不存在，请重新登录");
        }
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(admin.getPassword())).build();
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new CustomException("token验证失败，请重新登录");
        }

        return true;
    }
}
