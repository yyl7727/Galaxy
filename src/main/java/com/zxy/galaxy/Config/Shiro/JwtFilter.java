package com.zxy.galaxy.Config.Shiro;

import com.alibaba.fastjson.JSON;
import com.zxy.galaxy.Common.Result;
import com.zxy.galaxy.Common.Util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends AuthenticatingFilter {
    @Autowired
    JwtUtils jwtUtils;

    /**
     * 创建token
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws Exception
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = httpServletRequest.getHeader("Authorazation");
        if(StringUtils.isEmpty(token)){
            return null;
        }
        return new Token(token);
    }

    /**
     * 拦截
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = httpServletRequest.getHeader("Authorazation");
        if(StringUtils.isEmpty(token)){
            return true;
        } else {
            //校验token
            Claims claims = jwtUtils.getClamiByToken(token);
            if (claims == null || jwtUtils.isTokenExpired(claims.getExpiration())) {
                throw new ExpiredCredentialsException("长时间未操作，请重新登录！");
            }
            return executeLogin(servletRequest, servletResponse);
        }
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        Throwable throwable = e.getCause() == null ? e : e.getCause();
        Result result = Result.fail(throwable.getMessage());
        String resultJson = JSON.toJSONString(result);
        try {
            httpServletResponse.getWriter().println(resultJson);
        } catch (IOException ioException) {

        }
        return false;
    }
}
