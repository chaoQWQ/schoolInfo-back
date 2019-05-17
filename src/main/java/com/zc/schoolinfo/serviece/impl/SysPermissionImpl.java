package com.zc.schoolinfo.serviece.impl;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.dao.SysPermissionMapper;
import com.zc.schoolinfo.model.pojo.SysPermission;
import com.zc.schoolinfo.serviece.SysPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Override
    public int addPermission(SysPermission permission) {
        return sysPermissionMapper.insertSelective(permission);
    }

    @Override
    public int updatePermission(SysPermission permission) {
        return sysPermissionMapper.updateByPrimaryKeySelective(permission);
    }

    @Override
    public int deletePermission(Integer id) {
        return sysPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<SysPermission> getAllByPage( Integer pageNum,  Integer pageSize) {
        return sysPermissionMapper.getAllByPage(pageNum,pageSize);
    }

    @Override
    public List<SysPermission> getAll() {
        return sysPermissionMapper.getAll();
    }
}
