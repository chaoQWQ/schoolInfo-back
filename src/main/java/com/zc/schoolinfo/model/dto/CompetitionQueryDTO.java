package com.zc.schoolinfo.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/9 11:34
 * @Version 1.0
 **/
@Data
public class CompetitionQueryDTO implements Serializable {
    private static final long serialVersionUID = 8507465893309312285L;

    private String scope;
    private String state;
    private List<String> type;
    private String sort;

    private Integer pageNum = 1;
    private Integer pageSize = 10;


}
