package com.zc.schoolinfo.dao;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.model.dto.VolunteerQueryDTO;
import com.zc.schoolinfo.model.pojo.SocietyActivity;
import com.zc.schoolinfo.model.pojo.VolunteerActivity;
import com.zc.schoolinfo.model.pojo.VolunteerActivityExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface VolunteerActivityMapper {
    int countByExample(VolunteerActivityExample example);

    int deleteByExample(VolunteerActivityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VolunteerActivity record);

    int insertSelective(VolunteerActivity record);

    List<VolunteerActivity> selectByExample(VolunteerActivityExample example);

    VolunteerActivity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VolunteerActivity record, @Param("example") VolunteerActivityExample example);

    int updateByExample(@Param("record") VolunteerActivity record, @Param("example") VolunteerActivityExample example);

    int updateByPrimaryKeySelective(VolunteerActivity record);

    int updateByPrimaryKey(VolunteerActivity record);

    Page<VolunteerActivity> queryByPage(VolunteerQueryDTO volunteerQueryDTO);

    VolunteerActivity getDetail(@Param("id")Integer id);

    List<Map<String,Object>> getJoinInfo(@Param("id")Integer id);

    void raiseJoinNumbers(@Param("id")Integer id);

    void insertJoin(@Param("id")Integer id, @Param("userId")Integer userId);

    List<VolunteerActivity> getHotTitle();

    Page<SocietyActivity> getMy(@Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize,@Param("author")String author);
}