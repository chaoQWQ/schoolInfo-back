package com.zc.schoolinfo.serviece.impl;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.dao.VolunteerActivityMapper;
import com.zc.schoolinfo.model.dto.VolunteerQueryDTO;
import com.zc.schoolinfo.model.pojo.SocietyActivity;
import com.zc.schoolinfo.model.pojo.VolunteerActivity;
import com.zc.schoolinfo.serviece.VolunteerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/29 15:58
 * @Version 1.0
 **/
@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Resource
    private VolunteerActivityMapper volunteerActivityMapper;


    @Override
    public int addVolunteer(VolunteerActivity volunteerActivity) {
        return volunteerActivityMapper.insertSelective(volunteerActivity);
    }

    @Override
    public Page<VolunteerActivity> queryByPage(VolunteerQueryDTO volunteerQueryDTO) {
        return volunteerActivityMapper.queryByPage(volunteerQueryDTO);
    }

    @Override
    public List<VolunteerActivity> getHotTitle() {
        return volunteerActivityMapper.getHotTitle();
    }

    @Override
    public VolunteerActivity getDetail(Integer id) {
        return volunteerActivityMapper.getDetail(id);
    }

    @Override
    public List<Map<String, Object>> getJoinInfo(Integer id) {
        return volunteerActivityMapper.getJoinInfo(id);
    }

    @Transactional
    @Override
    public void joinVolunteer(Integer id, Integer userId) {
        volunteerActivityMapper.raiseJoinNumbers(id);
        volunteerActivityMapper.insertJoin(id, userId);
    }

    @Override
    public int updateVolunteer(VolunteerActivity volunteerActivity) {
        return volunteerActivityMapper.updateByPrimaryKeySelective(volunteerActivity);
    }

    @Override
    public Page<SocietyActivity> getMy(Integer pageNum, Integer pageSize, String author) {
        return volunteerActivityMapper.getMy(pageNum,pageSize,author);
    }

    @Override
    public int deleteVolunteer(Integer id) {
        return volunteerActivityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean checkRemain(Integer id) {
        VolunteerActivity volunteerActivity = volunteerActivityMapper.selectByPrimaryKey(id);
        if (volunteerActivity.getJoinNumbers() < volunteerActivity.getRecruitNumbers()) {
            return true;
        }
        return false;
    }
}
