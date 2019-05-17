package com.zc.schoolinfo.serviece;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.model.dto.LoginParam;
import com.zc.schoolinfo.model.dto.SignUpParam;
import com.zc.schoolinfo.model.dto.UserQuery;
import com.zc.schoolinfo.model.pojo.SysUser;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/18 11:19
 * @Version 1.0
 **/
public interface SysUserService {
    SysUser findByUserName(String username);

    int signUp(SignUpParam signUpParam);

    int updateInfo(SysUser sysUser);

    Page<SysUser> findByPage(UserQuery userQuery);

    int deleteUser(Integer id);

    int insertUser(SysUser sysUser);
}
