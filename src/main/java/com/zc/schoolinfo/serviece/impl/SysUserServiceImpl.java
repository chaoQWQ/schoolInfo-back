package com.zc.schoolinfo.serviece.impl;

import com.zc.schoolinfo.common.utils.MD5Util;
import com.zc.schoolinfo.dao.SysUserMapper;
import com.zc.schoolinfo.model.dto.LoginParam;
import com.zc.schoolinfo.model.dto.SignUpParam;
import com.zc.schoolinfo.model.pojo.SysUser;
import com.zc.schoolinfo.serviece.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/18 11:19
 * @Version 1.0
 **/
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findByUserName(String username) {
        return sysUserMapper.findByUserName(username);
    }

    @Override
    public int signUp(SignUpParam signUpParam) {
        SysUser user = new SysUser();
        user.setUsername(signUpParam.getS_username());
        user.setSalt(signUpParam.getS_username());
        user.setPassword(MD5Util.MD5EncodeWithSalt(signUpParam.getS_password(), signUpParam.getS_username()));
        user.setAvatar(sysUserMapper.getAvatar());
        return sysUserMapper.insertSelective(user);
    }
}
