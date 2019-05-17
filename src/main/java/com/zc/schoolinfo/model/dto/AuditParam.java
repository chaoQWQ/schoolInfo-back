package com.zc.schoolinfo.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/5/8 17:23
 * @Version 1.0
 **/
@Data
public class AuditParam implements Serializable {

    private static final long serialVersionUID = -5709906746624966983L;

    private Integer id;
    private String reason;
    private String auditOption;
}
