package com.zc.schoolinfo.serviece.impl;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.common.utils.MD5Util;
import com.zc.schoolinfo.dao.SysUserMapper;
import com.zc.schoolinfo.model.dto.LoginParam;
import com.zc.schoolinfo.model.dto.SignUpParam;
import com.zc.schoolinfo.model.dto.UserQuery;
import com.zc.schoolinfo.model.enums.RoleEnum;
import com.zc.schoolinfo.model.pojo.SysUser;
import com.zc.schoolinfo.serviece.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;

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
    public int updateInfo(SysUser sysUser) {
        sysUserMapper.insertRU(sysUser.getId(),sysUser.getUserType());
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public Page<SysUser> findByPage(UserQuery userQuery) {
        return sysUserMapper.findByPage(userQuery);
    }

    @Override
    public int insertUser(SysUser sysUser) {
        sysUser.setSalt(sysUser.getUsername());
        sysUser.setPassword(MD5Util.MD5EncodeWithSalt(MD5Util.MD5Encode("123456"),sysUser.getUsername()));
        sysUser.setAvatar(sysUserMapper.getAvatar());
        sysUserMapper.insertSelective(sysUser);
        return sysUserMapper.insertRU(sysUser.getId(), sysUser.getUserType());
    }

    @Override
    public int deleteUser(Integer id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int signUp(SignUpParam signUpParam) {
        SysUser user = new SysUser();
        user.setUsername(signUpParam.getS_username());
        user.setSalt(signUpParam.getS_username());
        String pwd = MD5Util.MD5Encode(signUpParam.getS_password());
        user.setPassword(MD5Util.MD5EncodeWithSalt(pwd, signUpParam.getS_username()));
        user.setAvatar(sysUserMapper.getAvatar());
        sysUserMapper.insertSelective(user);
        return sysUserMapper.insertRU(user.getId(), RoleEnum.USER.name());
    }
}
