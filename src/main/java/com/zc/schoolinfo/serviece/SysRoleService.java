package com.zc.schoolinfo.serviece;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.model.pojo.SysRole;

import java.util.List;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/18 11:23
 * @Version 1.0
 **/
public interface SysRoleService {
    List<SysRole> getAll();

    Page<SysRole> findByPage(Integer pageNum, Integer pageSize);

    int deleteRole(Integer id);

    int updateRole(SysRole sysRole);

    int addRole(SysRole sysRole);

    void insertRP(Integer id, Integer id1);

    void deleteRPById(Integer roleId);
//    List<SysRole> findRoleByUsername(String username);
}
