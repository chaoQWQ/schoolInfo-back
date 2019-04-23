package com.zc.schoolinfo.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/19 16:51
 * @Version 1.0
 **/
@Data
public class SignUpParam implements Serializable {

    private static final long serialVersionUID = 6960659367084258928L;

    private String s_username;
    private String s_password;
}
