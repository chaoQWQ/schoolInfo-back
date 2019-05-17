package com.zc.schoolinfo.controller;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.common.WebApiResult;
import com.zc.schoolinfo.model.dto.CompetitionQueryDTO;
import com.zc.schoolinfo.model.enums.WebApiResultCodeEnum;
import com.zc.schoolinfo.model.pojo.BizCompetitionInfo;
import com.zc.schoolinfo.model.pojo.SocietyActivity;
import com.zc.schoolinfo.model.pojo.SysUser;
import com.zc.schoolinfo.model.pojo.VolunteerActivity;
import com.zc.schoolinfo.serviece.CompetitionService;
import com.zc.schoolinfo.serviece.SocietyActivityService;
import com.zc.schoolinfo.serviece.VolunteerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/9 10:22
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/compinfo")

public class CompetitionController {


    @Resource
    private CompetitionService competitionServiece;

    @Autowired
    private VolunteerService volunteerService;

    @Autowired
    private SocietyActivityService activityService;
    @GetMapping("/getTitle")
    public WebApiResult getTitle() {
        List<Map<String,Object>> re1 =competitionServiece.getHotTitle("校级");
        List<Map<String,Object>> re2 =competitionServiece.getHotTitle("国级");
        List<VolunteerActivity> re3 = volunteerService.getHotTitle();
        List<SocietyActivity> re4 = activityService.getHotTitle();
        List<List> re = new ArrayList<>();
        re.add(re1);
        re.add(re2);
        re.add(re3);
        re.add(re4);
        return WebApiResult.buildSuccess(re);
    }

    @GetMapping("/getTypeList")
    public WebApiResult getTypeList() {
        List<Map<String, Object>> re = competitionServiece.getTypeList();
        return WebApiResult.buildSuccess(re);
    }

    @PostMapping("/competition")
    public WebApiResult getCompetition(@RequestBody CompetitionQueryDTO competitionQueryDTO) {
        Page<BizCompetitionInfo> page = competitionServiece.getCompetitionByPage(competitionQueryDTO);
        return WebApiResult.buildSuccess(page);
    }

    @GetMapping("/getDetail")
    public WebApiResult getDetail(@RequestParam Integer id) {
        if (id == null) {
            return WebApiResult.build(WebApiResultCodeEnum.PARAM_IS_NULL);
        }
        BizCompetitionInfo bizCompetitionInfo = competitionServiece.getCompetitionDetailInfo(id);
        competitionServiece.raiseViewNumbers(id);
        return WebApiResult.buildSuccess(bizCompetitionInfo);
    }

    @PostMapping("/submit")
//    @RequiresPermissions("compinfo:submit")
    public WebApiResult submit(@RequestBody BizCompetitionInfo competitionInfo) {
        SysUser currentUser = (SysUser)SecurityUtils.getSubject().getPrincipal();
        competitionInfo.setAuthor(currentUser.getUsername());
        if (competitionServiece.submitCompInfo(competitionInfo)==0){
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }
    @PostMapping("/update")
    public WebApiResult update(@RequestBody BizCompetitionInfo competitionInfo) {

        if (competitionServiece.updateCompInfo(competitionInfo)==0){
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }
    @DeleteMapping("/delete")
    public WebApiResult delete(@RequestParam Integer id) {

        if (competitionServiece.deleteCompInfo(id)==0){
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }
    @GetMapping("/getMy")
    public WebApiResult getMy(@RequestParam Integer pageNum ,@RequestParam Integer pageSize,@RequestParam String author) {
        Page<BizCompetitionInfo> page = competitionServiece.getMy(pageNum,pageSize,author);
        return WebApiResult.buildSuccess(page);
    }
}
