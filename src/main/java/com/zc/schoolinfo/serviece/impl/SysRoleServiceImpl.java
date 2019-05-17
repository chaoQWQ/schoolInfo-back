package com.zc.schoolinfo.serviece.impl;

import com.github.pagehelper.Page;
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

    @Override
    public void deleteRPById(Integer roleId) {
        sysRoleMapper.deleteRpById(roleId);
    }

    @Override
    public void insertRP(Integer id, Integer id1) {
        sysRoleMapper.insertRP(id, id1);
    }

    @Override
    public int addRole(SysRole sysRole) {
        return sysRoleMapper.insertSelective(sysRole);
    }

    @Override
    public int updateRole(SysRole sysRole) {
        return sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    @Override
    public int deleteRole(Integer id) {
        return sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<SysRole> findByPage(Integer pageNum, Integer pageSize) {
        return sysRoleMapper.findByPage(pageNum, pageSize);
    }

    @Override
    public List<SysRole> getAll() {
        return sysRoleMapper.getAll();
    }

//    @Override
//    public List<SysRole> findRoleByUsername(String username) {
//        return sysRoleMapper.findRoleByUsername(username);
//    }
}
