package com.zc.schoolinfo.serviece;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.model.dto.CompetitionQueryDTO;
import com.zc.schoolinfo.model.pojo.BizCompetitionInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/9 10:42
 * @Version 1.0
 **/

public interface CompetitionServiece {
    Page<BizCompetitionInfo> getCompetitionByPage(CompetitionQueryDTO competitionDTO);


    List<Map<String,Object>> getHotTitle(String type);

    BizCompetitionInfo getCompetitionDetailInfo(Integer id);

    void raiseViewNumbers(Integer id);

    List<Map<String,Object>> getTypeList();

    int submitCompInfo(BizCompetitionInfo competitionInfo);
}
