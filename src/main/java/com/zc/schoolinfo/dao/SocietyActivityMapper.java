package com.zc.schoolinfo.dao;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.model.pojo.SocietyActivity;
import com.zc.schoolinfo.model.pojo.SocietyActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SocietyActivityMapper {
    int countByExample(SocietyActivityExample example);

    int deleteByExample(SocietyActivityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SocietyActivity record);

    int insertSelective(SocietyActivity record);

    List<SocietyActivity> selectByExample(SocietyActivityExample example);

    SocietyActivity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SocietyActivity record, @Param("example") SocietyActivityExample example);

    int updateByExample(@Param("record") SocietyActivity record, @Param("example") SocietyActivityExample example);

    int updateByPrimaryKeySelective(SocietyActivity record);

    int updateByPrimaryKey(SocietyActivity record);

    List<SocietyActivity> queryByPage(@Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    int raiseViewNumbers(Integer id);

    List<SocietyActivity> getHotTitle();

    Page<SocietyActivity> getMy(@Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize,@Param("author")String author);
}