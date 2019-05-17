package com.zc.schoolinfo.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/5/7 0:04
 * @Version 1.0
 **/
@Data
public class PwdParam implements Serializable {

    private static final long serialVersionUID = 6317890315905919669L;

    private String oldPassword;
    private String newPassword;

}
