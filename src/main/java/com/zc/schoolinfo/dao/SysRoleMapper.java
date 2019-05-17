package com.zc.schoolinfo.dao;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.model.pojo.SysRole;
import com.zc.schoolinfo.model.pojo.sysRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper {
    int countByExample(sysRoleExample example);

    int deleteByExample(sysRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(sysRoleExample example);

    SysRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") sysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") sysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> getAll();

    Page<SysRole> findByPage(@Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    void insertRP(@Param("rid")Integer rid, @Param("pid")Integer pid);

    void deleteRpById(@Param("roleId")Integer roleId);

//    List<SysRole> findRoleByUsername(@Param("username") username);
}