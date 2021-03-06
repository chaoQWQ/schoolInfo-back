package com.zc.schoolinfo.dao;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.model.dto.UserQuery;
import com.zc.schoolinfo.model.pojo.SysUser;
import com.zc.schoolinfo.model.pojo.SysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser findByUserName(@Param("username") String username);

    SysUser findByEmail(@Param("email") String email);

    String getAvatar();

    int insertRU(@Param("userId") Integer userId, @Param("roleName") String roleName);

    Page<SysUser> findByPage(UserQuery userQuery);
}