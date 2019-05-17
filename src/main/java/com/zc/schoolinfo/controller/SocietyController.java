package com.zc.schoolinfo.controller;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.common.WebApiResult;
import com.zc.schoolinfo.model.enums.WebApiResultCodeEnum;
import com.zc.schoolinfo.model.pojo.BizCompetitionInfo;
import com.zc.schoolinfo.model.pojo.SocietyActivity;
import com.zc.schoolinfo.model.pojo.SysUser;
import com.zc.schoolinfo.serviece.SocietyActivityService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/27 21:58
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/society")
public class SocietyController {

    @Autowired
    private SocietyActivityService societyActivityService;

    @GetMapping("/query")
    public WebApiResult queryByPage(@RequestParam Integer pageNum ,@RequestParam Integer pageSize) {
        List<SocietyActivity> result = societyActivityService.queryByPage(pageNum,pageSize);
        return WebApiResult.buildSuccess(result);
    }

    @GetMapping("getDetail")
    public WebApiResult getDetail(@RequestParam Integer id) {
        if (id == null) {
            return WebApiResult.build(WebApiResultCodeEnum.PARAM_IS_NULL);
        }
        SocietyActivity societyActivity = societyActivityService.getSocietyActivityDetail(id);
        societyActivityService.raiseViewNumbers(id);
        return WebApiResult.buildSuccess(societyActivity);
    }
    @PostMapping("/submit")
    public WebApiResult submit(@RequestBody SocietyActivity societyActivity){
        SysUser currentUser = (SysUser)SecurityUtils.getSubject().getPrincipal();
        societyActivity.setAuthor(currentUser.getUsername());
        if (societyActivityService.addActivity(societyActivity) != 0) {
            return WebApiResult.buildSuccess(null);
        }
        return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
    }

    @PostMapping("/update")
    public WebApiResult update(@RequestBody SocietyActivity societyActivity) {

        if (societyActivityService.updateSocietyActivity(societyActivity)==0){
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }
    @DeleteMapping("/delete")
    public WebApiResult delete(@RequestParam Integer id) {
        if (societyActivityService.deleteSocietyActivity(id)==0){
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }
    @GetMapping("/getMy")
    public WebApiResult getMy(@RequestParam Integer pageNum ,@RequestParam Integer pageSize,@RequestParam String author) {
        Page<SocietyActivity> page = societyActivityService.getMy(pageNum,pageSize,author);
        return WebApiResult.buildSuccess(page);
    }
}
