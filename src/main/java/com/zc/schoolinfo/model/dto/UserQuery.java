package com.zc.schoolinfo.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/5/9 16:30
 * @Version 1.0
 **/
@Data
public class UserQuery implements Serializable {
    private static final long serialVersionUID = 7339022495522184670L;

    private String userName;
    private String userType;

    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
