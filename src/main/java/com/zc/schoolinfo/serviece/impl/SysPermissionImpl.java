package com.zc.schoolinfo.serviece.impl;

import com.zc.schoolinfo.dao.SysPermissionMapper;
import com.zc.schoolinfo.serviece.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/18 11:36
 * @Version 1.0
 **/
@Service
public class SysPermissionImpl implements SysPermissionService {
    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<String> selectPermissionByUserId(Integer id) {
        return sysPermissionMapper.selectPermissionByUserId(id);
    }
}
