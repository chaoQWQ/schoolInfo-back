package com.zc.schoolinfo.serviece;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.model.dto.VolunteerQueryDTO;
import com.zc.schoolinfo.model.pojo.SocietyActivity;
import com.zc.schoolinfo.model.pojo.VolunteerActivity;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/29 15:57
 * @Version 1.0
 **/
public interface VolunteerService {
    int addVolunteer(VolunteerActivity volunteerActivity);

    Page<VolunteerActivity> queryByPage(VolunteerQueryDTO volunteerQueryDTO);

    List<VolunteerActivity> getHotTitle();
    VolunteerActivity getDetail(Integer id);

    List<Map<String,Object>> getJoinInfo(Integer id);

    void joinVolunteer(Integer id, Integer userId);

    boolean checkRemain(Integer id);

    int updateVolunteer(VolunteerActivity volunteerActivity);

    int deleteVolunteer(Integer id);

    Page<SocietyActivity> getMy(Integer pageNum, Integer pageSize, String author);
}
