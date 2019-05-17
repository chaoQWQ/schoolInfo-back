package com.zc.schoolinfo.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/30 9:18
 * @Version 1.0
 **/
@Data
public class VolunteerQueryDTO implements Serializable {

    private static final long serialVersionUID = -923605798978196144L;

    private List<String> type;
    private String state;
    private String numbers;
    private String sort;

    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
