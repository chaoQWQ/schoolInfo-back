package com.zc.schoolinfo.serviece.impl;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.dao.BizCompetitionInfoMapper;
import com.zc.schoolinfo.model.dto.CompetitionQueryDTO;
import com.zc.schoolinfo.model.enums.StatusEnum;
import com.zc.schoolinfo.model.pojo.BizCompetitionInfo;
import com.zc.schoolinfo.serviece.CompetitionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/9 10:44
 * @Version 1.0
 **/
@Service
public class CompetitionServiceImpl implements CompetitionService {
    @Resource
    private BizCompetitionInfoMapper competitionInfoMapper;

    @Override
    public Page<BizCompetitionInfo> getCompetitionByPage(CompetitionQueryDTO competitionDTO) {
        return competitionInfoMapper.getCompetitionByPage(competitionDTO);
    }

    @Override
    public List<Map<String, Object>> getHotTitle(String type) {
        return competitionInfoMapper.getHotTitle(type);
    }

    @Override
    public BizCompetitionInfo getCompetitionDetailInfo(Integer id) {
        return competitionInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void raiseViewNumbers(Integer id) {
        competitionInfoMapper.raiseViewNumbers(id);
    }

    @Override
    public List<Map<String, Object>> getTypeList() {
        return competitionInfoMapper.getTypeList();
    }

    @Override
    public Page<BizCompetitionInfo> getPendingAudit(Integer pageNum, Integer pageSize) {
        return competitionInfoMapper.getPendingAudit(pageNum, pageSize);
    }

    @Override
    public int submitCompInfo(BizCompetitionInfo competitionInfo) {
        competitionInfo.setStatus(StatusEnum.PENDING_REVIEW.name());
        return competitionInfoMapper.insertSelective(competitionInfo);
    }

    @Override
    public int updateCompInfo(BizCompetitionInfo competitionInfo) {
        return competitionInfoMapper.updateByPrimaryKeySelective(competitionInfo);
    }

    @Override
    public Page<BizCompetitionInfo> getMy(Integer pageNum,Integer pageSize,String author) {
        return competitionInfoMapper.getMy(pageNum, pageSize,author);
    }

    @Override
    public int deleteCompInfo(Integer id) {
        return competitionInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateCompInfoStatus(Integer id,String status) {
        BizCompetitionInfo competitionInfo = new BizCompetitionInfo();
        competitionInfo.setId(id);
        competitionInfo.setStatus(status);
        competitionInfoMapper.updateByPrimaryKeySelective(competitionInfo);
    }
}
