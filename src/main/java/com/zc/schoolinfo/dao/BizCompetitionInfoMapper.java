package com.zc.schoolinfo.dao;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.model.dto.CompetitionQueryDTO;
import com.zc.schoolinfo.model.pojo.BizCompetitionInfo;
import com.zc.schoolinfo.model.pojo.BizCompetitionInfoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BizCompetitionInfoMapper {
    int countByExample(BizCompetitionInfoExample example);

    int deleteByExample(BizCompetitionInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizCompetitionInfo record);

    int insertSelective(BizCompetitionInfo record);

    List<BizCompetitionInfo> selectByExample(BizCompetitionInfoExample example);

    BizCompetitionInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizCompetitionInfo record, @Param("example") BizCompetitionInfoExample example);

    int updateByExample(@Param("record") BizCompetitionInfo record, @Param("example") BizCompetitionInfoExample example);

    int updateByPrimaryKeySelective(BizCompetitionInfo record);

    int updateByPrimaryKey(BizCompetitionInfo record);

    Page<BizCompetitionInfo> getCompetitionByPage(CompetitionQueryDTO competitionDTO);

    List<Map<String,Object>> getHotTitle(@Param("type")String type);

    void raiseViewNumbers(Integer id);

    List<Map<String,Object>> getTypeList();

    Page<BizCompetitionInfo> getPendingAudit(@Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    Page<BizCompetitionInfo> getMy(@Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize,@Param("author")String author);
}