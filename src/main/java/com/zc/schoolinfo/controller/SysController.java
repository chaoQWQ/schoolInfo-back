package com.zc.schoolinfo.controller;

import com.zc.schoolinfo.common.WebApiResult;
import com.zc.schoolinfo.common.utils.MD5Util;
import com.zc.schoolinfo.common.utils.PwdGenerator;
import com.zc.schoolinfo.model.dto.LoginParam;
import com.zc.schoolinfo.model.dto.PwdParam;
import com.zc.schoolinfo.model.dto.SignUpParam;
import com.zc.schoolinfo.model.dto.VerifyParam;
import com.zc.schoolinfo.model.enums.WebApiResultCodeEnum;
import com.zc.schoolinfo.model.pojo.SysUser;
import com.zc.schoolinfo.serviece.SysPermissionService;
import com.zc.schoolinfo.serviece.SysUserService;
import com.zc.schoolinfo.serviece.impl.MailService;
import org.apache.catalina.loader.WebappClassLoader;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

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
    private MailService mailService;
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
            System.err.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println(e.getCause());
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
    }

    @GetMapping("/notLogin")
    public WebApiResult notLogin() {
        return WebApiResult.build(WebApiResultCodeEnum.NOT_HAVE_PERMISSION);
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
    @GetMapping("/checkFUserName")
    public WebApiResult checkFUserName(@RequestParam String username) {
        SysUser sysUser = sysUserService.findByUserName(username);
        if ( sysUser== null) {
            return WebApiResult.build(WebApiResultCodeEnum.USER_NOT_EXIST);
        }
        if (sysUser.getEmail()==null||sysUser.getEmail().equals("")){
            return WebApiResult.build(WebApiResultCodeEnum.NOT_BINDING);
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

    @PostMapping("/updateUser")
    public WebApiResult updateUser(@RequestBody SysUser sysUser) {

        if (sysUserService.updateInfo(sysUser) == 0) {
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }

    @GetMapping("/sendEmail")
    public WebApiResult sendEmail(HttpSession httpSession, @RequestParam Integer id, @RequestParam String emailurl) {
        String code=String.valueOf((int)((Math.random()*9+1)*100000));
        mailService.sendVerifyMail(emailurl,code);
        httpSession.setAttribute(String.valueOf(id),code+emailurl);
        return WebApiResult.buildSuccess(null);
    }
    @GetMapping("/sendFindEmail")
    public WebApiResult sendFindEmail(HttpSession httpSession,@RequestParam String username) {
        String code=String.valueOf((int)((Math.random()*9+1)*100000));
        SysUser user = sysUserService.findByUserName(username);
        mailService.sendVerifyMail(user.getEmail(),code);
        httpSession.setAttribute(username,code+username);
        return WebApiResult.buildSuccess(null);
    }

    @PostMapping("/bindEmail")
    public WebApiResult bindEmail(HttpSession httpSession, @RequestBody VerifyParam verifyParam) {
        String code = (String)httpSession.getAttribute(Integer.toString(verifyParam.getId()));
        if (code == null) {
            return WebApiResult.build(WebApiResultCodeEnum.AUTHCODE_ERROR);
        }
        if (!code.equals(verifyParam.getAuthCode()+verifyParam.getBemail())) {
            return WebApiResult.build(WebApiResultCodeEnum.AUTHCODE_ERROR);
        }
        httpSession.removeAttribute(Integer.toString(verifyParam.getId()));
        SysUser user = new SysUser();
        user.setId(verifyParam.getId());
        user.setEmail(verifyParam.getBemail());
        if(sysUserService.updateInfo(user)==1){
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }

    @PostMapping("/updatePassword")
    public WebApiResult updatePassword(@RequestBody PwdParam pwdParam) {
        SysUser currentUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        if(!currentUser.getPassword().equals(MD5Util.MD5EncodeWithSalt(pwdParam.getOldPassword(), currentUser.getSalt()))){
            return WebApiResult.build("000037", "原密码错误");
        }
        SysUser user = new SysUser();
        String s1 = MD5Util.MD5EncodeWithSalt(pwdParam.getNewPassword(), currentUser.getSalt());
        user.setId(currentUser.getId());
        user.setPassword(s1);
        if(sysUserService.updateInfo(user)==1){
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }

    @GetMapping("/findPassword")
    public WebApiResult findPassword(HttpSession httpSession, @RequestParam String username, @RequestParam String authCode) {
        String code = (String)httpSession.getAttribute(username);
        if (code == null) {
            return WebApiResult.build(WebApiResultCodeEnum.AUTHCODE_ERROR);
        }
        if (!code.equals(authCode+username)) {
            return WebApiResult.build(WebApiResultCodeEnum.AUTHCODE_ERROR);
        }
        SysUser user = sysUserService.findByUserName(username);
        String pwd = PwdGenerator.genRandomNum(10);
        String s = MD5Util.MD5Encode(pwd);
        String s1 = MD5Util.MD5EncodeWithSalt(s, user.getSalt());
        user.setPassword(s1);
        sysUserService.updateInfo(user);
        httpSession.removeAttribute(username);
        mailService.sendResetPassWordEmail(user.getEmail(),username,pwd);
        return WebApiResult.buildSuccess(null);
    }
}
