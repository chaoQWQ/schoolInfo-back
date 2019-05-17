package com.zc.schoolinfo.serviece.impl;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.dao.SocietyActivityMapper;
import com.zc.schoolinfo.model.pojo.SocietyActivity;
import com.zc.schoolinfo.serviece.SocietyActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/28 9:42
 * @Version 1.0
 **/
@Service
public class SocietyActivityServiceImpl implements SocietyActivityService {
    @Resource
    private SocietyActivityMapper societyActivityMapper;
    @Override
    public int addActivity(SocietyActivity societyActivity) {
        return societyActivityMapper.insertSelective(societyActivity);
    }

    @Override
    public List<SocietyActivity> getHotTitle() {
        return societyActivityMapper.getHotTitle();
    }

    @Override
    public List<SocietyActivity> queryByPage(Integer pageNum, Integer pageSize) {
        return societyActivityMapper.queryByPage(pageNum,pageSize);
    }

    @Override
    public int updateSocietyActivity(SocietyActivity societyActivity) {
        return societyActivityMapper.updateByPrimaryKeySelective(societyActivity);
    }

    @Override
    public Page<SocietyActivity> getMy(Integer pageNum, Integer pageSize, String author) {
        return societyActivityMapper.getMy(pageNum,pageSize,author);
    }

    @Override
    public int deleteSocietyActivity(Integer id) {
        return societyActivityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int raiseViewNumbers(Integer id) {
        return societyActivityMapper.raiseViewNumbers(id);
    }

    @Override
    public SocietyActivity getSocietyActivityDetail(Integer id) {
        return societyActivityMapper.selectByPrimaryKey(id);
    }
}
