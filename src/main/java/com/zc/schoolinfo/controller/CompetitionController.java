package com.zc.schoolinfo.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.schoolinfo.common.WebApiResult;
import com.zc.schoolinfo.model.dto.CompetitionQueryDTO;
import com.zc.schoolinfo.model.enums.WebApiResultCodeEnum;
import com.zc.schoolinfo.model.pojo.BizCompetitionInfo;
import com.zc.schoolinfo.serviece.CompetitionServiece;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
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
    private CompetitionServiece competitionServiece;

    @GetMapping("/getTitle")
    public WebApiResult getTitle() {
        List<Map<String,Object>> re1 =competitionServiece.getHotTitle("校级");
        List<Map<String,Object>> re2 =competitionServiece.getHotTitle("国级");
        List<List> re = new ArrayList<>();
        re.add(re1);
        re.add(re2);
        return WebApiResult.buildSuccess(re);
    }

    @GetMapping("/getTypeList")
    public WebApiResult getTypeList() {
        List<Map<String, Object>> re = competitionServiece.getTypeList();
        return WebApiResult.buildSuccess(re);
    }

    @PostMapping("/competition")
    @RequiresPermissions("competition")
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
    public WebApiResult submit(@RequestBody BizCompetitionInfo competitionInfo) {
        if (competitionServiece.submitCompInfo(competitionInfo)==0){
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }

}
