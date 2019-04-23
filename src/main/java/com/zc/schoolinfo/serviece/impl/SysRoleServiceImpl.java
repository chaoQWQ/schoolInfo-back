package com.zc.schoolinfo.serviece.impl;

import com.zc.schoolinfo.dao.SysRoleMapper;
import com.zc.schoolinfo.model.pojo.SysRole;
import com.zc.schoolinfo.serviece.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/18 11:24
 * @Version 1.0
 **/
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

//    @Override
//    public List<SysRole> findRoleByUsername(String username) {
//        return sysRoleMapper.findRoleByUsername(username);
//    }
}
