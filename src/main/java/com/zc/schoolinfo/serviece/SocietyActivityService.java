package com.zc.schoolinfo.serviece;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.model.pojo.SocietyActivity;

import java.util.List;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/28 9:41
 * @Version 1.0
 **/
public interface SocietyActivityService {
    int addActivity(SocietyActivity societyActivity);

    List<SocietyActivity> queryByPage(Integer pageNum, Integer pageSize);

    List<SocietyActivity> getHotTitle();

    SocietyActivity getSocietyActivityDetail(Integer id);

    int raiseViewNumbers(Integer id);

    int deleteSocietyActivity(Integer id);

    Page<SocietyActivity> getMy(Integer pageNum, Integer pageSize, String author);

    int updateSocietyActivity(SocietyActivity societyActivity);
}
