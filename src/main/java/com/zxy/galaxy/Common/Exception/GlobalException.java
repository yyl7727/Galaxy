package com.zxy.galaxy.Common.Exception;

import com.zxy.galaxy.Common.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalException {
    /**
     * 运行时异常
     * @param runtimeException
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result handle(RuntimeException runtimeException) {
        log.error("运行时异常-----------------{}", runtimeException);
        return Result.fail(runtimeException.getMessage());
    }

    /**
     * shiro中报出的异常
     * @param shiroException
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public Result handle(ShiroException shiroException) {
        log.error("Shiro中异常---------------{}", shiroException);
        return Result.fail("401", shiroException.getMessage(), null);
    }
}
