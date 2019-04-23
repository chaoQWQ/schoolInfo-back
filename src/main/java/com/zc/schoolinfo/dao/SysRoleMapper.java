package com.zc.schoolinfo.dao;

import com.zc.schoolinfo.model.pojo.SysRole;
import com.zc.schoolinfo.model.pojo.sysRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper {
    int countByExample(sysRoleExample example);

    int deleteByExample(sysRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(sysRoleExample example);

    SysRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") sysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") sysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

//    List<SysRole> findRoleByUsername(@Param("username") username);
}