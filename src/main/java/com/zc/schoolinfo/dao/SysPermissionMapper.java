package com.zc.schoolinfo.dao;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.model.pojo.SysPermission;
import com.zc.schoolinfo.model.pojo.sysPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPermissionMapper {
    int countByExample(sysPermissionExample example);

    int deleteByExample(sysPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    List<SysPermission> selectByExample(sysPermissionExample example);

    SysPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") sysPermissionExample example);

    int updateByExample(@Param("record") SysPermission record, @Param("example") sysPermissionExample example);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    List<String> selectPermissionByUserId(Integer id);

    List<SysPermission> getAll();

    Page<SysPermission> getAllByPage(@Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);
}