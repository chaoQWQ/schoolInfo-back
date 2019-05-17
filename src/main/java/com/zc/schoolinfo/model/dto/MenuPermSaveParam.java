package com.zc.schoolinfo.model.dto;

import com.zc.schoolinfo.model.pojo.SysPermission;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/5/10 1:19
 * @Version 1.0
 **/
@Data
public class MenuPermSaveParam implements Serializable {

    private static final long serialVersionUID = 8378571844670926614L;

    private Integer roleId;
    private List<SysPermission> permissions;
}
