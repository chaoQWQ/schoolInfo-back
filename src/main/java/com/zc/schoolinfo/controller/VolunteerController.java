package com.zc.schoolinfo.controller;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.common.WebApiResult;
import com.zc.schoolinfo.model.dto.JoinParam;
import com.zc.schoolinfo.model.dto.VolunteerQueryDTO;
import com.zc.schoolinfo.model.enums.WebApiResultCodeEnum;
import com.zc.schoolinfo.model.pojo.SocietyActivity;
import com.zc.schoolinfo.model.pojo.SysUser;
import com.zc.schoolinfo.model.pojo.VolunteerActivity;
import com.zc.schoolinfo.serviece.SysUserService;
import com.zc.schoolinfo.serviece.VolunteerService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/29 15:59
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/volunteer")
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/submit")
    public WebApiResult submit(@RequestBody VolunteerActivity volunteerActivity) {
        if (volunteerActivity == null) {
            return WebApiResult.build(WebApiResultCodeEnum.PARAM_IS_NULL);
        }
        SysUser currentUser = (SysUser)SecurityUtils.getSubject().getPrincipal();
        volunteerActivity.setAuthor(currentUser.getUsername());
        if(volunteerService.addVolunteer(volunteerActivity)==0){
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }

    @PostMapping("/query")
    public WebApiResult query(@RequestBody VolunteerQueryDTO volunteerQueryDTO) {
        if (volunteerQueryDTO == null) {
            return WebApiResult.build(WebApiResultCodeEnum.PARAM_IS_NULL);
        }
        Page<VolunteerActivity> re = volunteerService.queryByPage(volunteerQueryDTO);
        return WebApiResult.buildSuccess(re);
    }

    @GetMapping("/getDetail")
    public WebApiResult getDetail(@RequestParam Integer id) {
        if (id == null) {
            return WebApiResult.build(WebApiResultCodeEnum.PARAM_IS_NULL);
        }
        VolunteerActivity volunteerActivity= volunteerService.getDetail(id);
        SysUser author = sysUserService.findByUserName(volunteerActivity.getAuthor());
        HashMap<String, Object> result = new HashMap<>();
        result.put("volunteerInfo", volunteerActivity);
        result.put("authorInfo", author);
        return WebApiResult.buildSuccess(result);
    }

    @PostMapping("/join")
    public WebApiResult joinVolunteer(@RequestBody JoinParam joinParam) {
        if (joinParam == null || joinParam.getUserId() == null|| joinParam.getId() == null) {
            return WebApiResult.build(WebApiResultCodeEnum.PARAM_IS_NULL);
        }
        if(!volunteerService.checkRemain(joinParam.getId())){
            return WebApiResult.build(WebApiResultCodeEnum.INVENTORY_SHORTAGE);
        }
        volunteerService.joinVolunteer(joinParam.getId(), joinParam.getUserId());
        return WebApiResult.buildSuccess(null);
    }

    @GetMapping("/joinInfo")
    public WebApiResult getJoinInfo(@RequestParam Integer id) {
        if (id == null) {
            return WebApiResult.build(WebApiResultCodeEnum.PARAM_IS_NULL);
        }
        List<Map<String,Object>> re = volunteerService.getJoinInfo(id);
        return WebApiResult.buildSuccess(re);
    }

    @PostMapping("/update")
    public WebApiResult update(@RequestBody VolunteerActivity volunteerActivity) {

        if (volunteerService.updateVolunteer(volunteerActivity)==0){
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }
    @DeleteMapping("/delete")
    public WebApiResult delete(@RequestParam Integer id) {
        if (volunteerService.deleteVolunteer(id)==0){
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }
    @GetMapping("/getMy")
    public WebApiResult getMy(@RequestParam Integer pageNum ,@RequestParam Integer pageSize,@RequestParam String author) {
        Page<SocietyActivity> page = volunteerService .getMy(pageNum,pageSize,author);
        return WebApiResult.buildSuccess(page);
    }

}
