package com.zc.schoolinfo.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/5/6 20:16
 * @Version 1.0
 **/
@Data
public class VerifyParam implements Serializable {

    private static final long serialVersionUID = 4946850716199988304L;

    private Integer id;
    private String bemail;
    private String authCode;

}
