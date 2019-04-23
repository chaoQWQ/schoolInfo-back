package com.zc.schoolinfo.serviece;

import java.util.List;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/18 11:35
 * @Version 1.0
 **/
public interface SysPermissionService {
    List<String> selectPermissionByUserId(Integer id);
}
