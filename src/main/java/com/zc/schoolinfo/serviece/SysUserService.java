package com.zc.schoolinfo.serviece;

import com.zc.schoolinfo.model.dto.LoginParam;
import com.zc.schoolinfo.model.dto.SignUpParam;
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
}
