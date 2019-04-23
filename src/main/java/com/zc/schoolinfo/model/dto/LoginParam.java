package com.zc.schoolinfo.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/18 19:53
 * @Version 1.0
 **/
@Data
public class LoginParam implements Serializable {
    private static final long serialVersionUID = -5336610181550513444L;

    private String username;
    private String password;
}
