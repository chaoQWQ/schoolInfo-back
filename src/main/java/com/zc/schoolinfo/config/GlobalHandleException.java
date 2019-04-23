package com.zc.schoolinfo.config;

import com.zc.schoolinfo.common.WebApiResult;
import com.zc.schoolinfo.model.enums.WebApiResultCodeEnum;
import com.zc.schoolinfo.shiro.UserRealm;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/21 23:42
 * @Version 1.0
 **/
@ControllerAdvice
public class GlobalHandleException {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRealm.class);

    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public WebApiResult authorizedErrorHandler(HttpServletRequest request, AuthorizationException e) {
        LOGGER.info("捕获到未授权请求:"+request.getRequestURI());
        return WebApiResult.build(WebApiResultCodeEnum.NOT_HAVE_PERMISSION);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public WebApiResult ErrorHandler(HttpServletRequest request, Exception e) {
        LOGGER.info("来自"+request.getRequestURI()+"的未知错误请求");
        System.err.println(e.getMessage());
        return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
    }
}
