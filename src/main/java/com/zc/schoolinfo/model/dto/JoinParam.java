package com.zc.schoolinfo.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/5/4 17:57
 * @Version 1.0
 **/
@Data
public class JoinParam implements Serializable {

    private static final long serialVersionUID = 7688421500844375425L;

    private Integer id;
    private Integer userId;
}
