package com.zc.schoolinfo.serviece;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.model.dto.CompetitionQueryDTO;
import com.zc.schoolinfo.model.pojo.BizCompetitionInfo;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/9 10:42
 * @Version 1.0
 **/

public interface CompetitionService {
    Page<BizCompetitionInfo> getCompetitionByPage(CompetitionQueryDTO competitionDTO);


    List<Map<String,Object>> getHotTitle(String type);

    BizCompetitionInfo getCompetitionDetailInfo(Integer id);

    void raiseViewNumbers(Integer id);

    List<Map<String,Object>> getTypeList();

    int submitCompInfo(BizCompetitionInfo competitionInfo);

    Page<BizCompetitionInfo> getPendingAudit(Integer pageNum,Integer pageSize);

    void updateCompInfoStatus(Integer id,String status);

    Page<BizCompetitionInfo> getMy(Integer pageNum,Integer pageSize,String author);

    int updateCompInfo(BizCompetitionInfo competitionInfo);

    int deleteCompInfo(Integer id);
}
