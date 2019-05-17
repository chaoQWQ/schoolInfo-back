package com.zc.schoolinfo.model.enums;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/5/5 1:09
 * @Version 1.0
 **/
public enum RoleEnum {
    SUPER(1),
    ADMIN(2),
    USER(3),
    VADMIN(4),
    SADMIN(5),
    CADMIN(6);


    private Integer roleId;

    RoleEnum(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }
}
