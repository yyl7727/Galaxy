package com.zxy.galaxy.Config.Exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(AuthorizationException.class)
    public ModelAndView unAuthorizationException(AuthorizationException e) {
        ModelAndView modelAndView = new ModelAndView("403");
        modelAndView.addObject("message", "没有访问权限");
        return modelAndView;
    }
}
