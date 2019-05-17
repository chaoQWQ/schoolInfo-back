package com.zc.schoolinfo.serviece;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.model.pojo.SysPermission;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/18 11:35
 * @Version 1.0
 **/
public interface SysPermissionService {
    List<String> selectPermissionByUserId(Integer id);

    List<SysPermission> getAll();

    Page<SysPermission> getAllByPage( Integer pageNum,  Integer pageSize);

    int addPermission(SysPermission permission);

    int updatePermission(SysPermission permission);

    int deletePermission(Integer id);
}
