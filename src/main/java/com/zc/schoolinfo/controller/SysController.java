package com.zc.schoolinfo.controller;

import com.zc.schoolinfo.common.WebApiResult;
import com.zc.schoolinfo.model.dto.LoginParam;
import com.zc.schoolinfo.model.dto.SignUpParam;
import com.zc.schoolinfo.model.enums.WebApiResultCodeEnum;
import com.zc.schoolinfo.model.pojo.SysUser;
import com.zc.schoolinfo.serviece.SysPermissionService;
import com.zc.schoolinfo.serviece.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/18 8:57
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/sys")
public class SysController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @PostMapping("/login")
    public WebApiResult login(@RequestBody LoginParam loginParam) {
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginParam.getUsername(), loginParam.getPassword());
        try {
            user.login(token);
            SysUser currentUser = (SysUser)user.getPrincipal();
            currentUser.setPermissions(sysPermissionService.selectPermissionByUserId(currentUser.getId()));
            return WebApiResult.buildSuccess(currentUser);
        } catch (UnknownAccountException e) {
            return WebApiResult.build(WebApiResultCodeEnum.USER_NOT_EXIST);
        } catch (IncorrectCredentialsException e) {
            return WebApiResult.build(WebApiResultCodeEnum.PASSWORD_ERROR);
        } catch (Throwable e) {
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
    }

    @GetMapping("/logout")
    public WebApiResult logout() {
        try {
            SecurityUtils.getSubject().logout();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return WebApiResult.buildSuccess(null);
    }

    @GetMapping("/checkUserName")
    public WebApiResult checkUserName(@RequestParam String username) {
        if (sysUserService.findByUserName(username) != null) {
            return WebApiResult.build(WebApiResultCodeEnum.USER_EXIST);
        }
        return WebApiResult.buildSuccess(null);
    }

    @PostMapping("/signUp")
    public WebApiResult signUp(@RequestBody SignUpParam signUpParam) {
        if(sysUserService.signUp(signUpParam)==0){
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }
}
