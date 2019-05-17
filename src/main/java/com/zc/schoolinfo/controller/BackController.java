package com.zc.schoolinfo.controller;

import com.github.pagehelper.Page;
import com.zc.schoolinfo.common.WebApiResult;
import com.zc.schoolinfo.common.utils.MD5Util;
import com.zc.schoolinfo.model.dto.AuditParam;
import com.zc.schoolinfo.model.dto.MenuPermSaveParam;
import com.zc.schoolinfo.model.dto.UserQuery;
import com.zc.schoolinfo.model.enums.StatusEnum;
import com.zc.schoolinfo.model.enums.WebApiResultCodeEnum;
import com.zc.schoolinfo.model.pojo.*;
import com.zc.schoolinfo.serviece.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/5/8 10:51
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/back")
public class BackController {

    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService roleService;
    @Autowired
    private SysPermissionService permissionService;

    @GetMapping("/getPendingAudit")
    public WebApiResult getPendingAudit(@RequestParam Integer pageNum ,@RequestParam Integer pageSize){
        Page<BizCompetitionInfo> page = competitionService.getPendingAudit(pageNum,pageSize);
        return WebApiResult.buildSuccess(page);
    }

    @PostMapping("audit")
    public WebApiResult audit(@RequestBody AuditParam auditParam){
        if (auditParam.getAuditOption() == null) {
            return WebApiResult.build(WebApiResultCodeEnum.PARAM_IS_NULL);
        }
        BizCompetitionInfo competitionDetailInfo = competitionService.getCompetitionDetailInfo(auditParam.getId());

        String author = competitionDetailInfo.getAuthor();
        SysUser user = sysUserService.findByUserName(author);
        if ("1".equals(auditParam.getAuditOption())) {
            competitionService.updateCompInfoStatus(auditParam.getId(),StatusEnum.PASS.name());
            messageService.send(user.getId(), "您申请的比赛项目["+competitionDetailInfo.getTitle()+"]已通过审核。(额外说明："+auditParam.getReason()+")");
        }
        if ("2".equals(auditParam.getAuditOption())) {
            competitionService.updateCompInfoStatus(auditParam.getId(),StatusEnum.DRAFT.name());
            messageService.send(user.getId(), "您申请的比赛项目["+competitionDetailInfo.getTitle()+"]未通过审核。(额外说明："+auditParam.getReason()+")");
        }
        return WebApiResult.buildSuccess(null);
    }

    @GetMapping("/myMessage")
    public WebApiResult getMyMessage(@RequestParam Integer id,@RequestParam Integer pageNum ,@RequestParam Integer pageSize) {
        Page<Message> re = messageService.getMyMessage(pageNum,pageSize,id);
        return WebApiResult.buildSuccess(re);
    }

    @GetMapping("/getUserTypeList")
    public WebApiResult getUserTypeList() {
        List<SysRole> sysRole = roleService.getAll();
        return WebApiResult.buildSuccess(sysRole);
    }
    @PostMapping("/getUserList")
    public WebApiResult getUserList(@RequestBody UserQuery userQuery) {
        Page<SysUser> re = sysUserService.findByPage(userQuery);
        return WebApiResult.buildSuccess(re);
    }

    @DeleteMapping("/deleteUser")
    public WebApiResult deleteUser(@RequestParam Integer id) {
        if (sysUserService.deleteUser(id) == 0) {
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }

    @PostMapping("/addUser")
    public WebApiResult addUser(@RequestBody SysUser sysUser) {
        if (sysUser == null) {
            return WebApiResult.build(WebApiResultCodeEnum.PARAM_IS_NULL);
        }
        if (sysUserService.insertUser(sysUser) == 0) {
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }
    @GetMapping("/userAuthor")
    public WebApiResult userAuthor(@RequestParam Integer id, @RequestParam String userType) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setUserType(userType);
        if (sysUserService.updateInfo(sysUser) == 0) {
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);

    }

    @GetMapping("/getRoleList")
    public WebApiResult getRoleList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Page<SysRole> re = roleService.findByPage(pageNum, pageSize);
        return WebApiResult.buildSuccess(re);
    }

    @DeleteMapping("/deleteRole")
    public WebApiResult deleteRole(@RequestParam Integer id) {
        if (roleService.deleteRole(id) == 0) {
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }

    @PostMapping("/addOrUpdateRole")
    public WebApiResult addOrUpdateRole(@RequestBody SysRole sysRole) {
        if (sysRole.getId() == null || sysRole.getId() == 0) {
            sysRole.setId(null);
            if (roleService.addRole(sysRole) == 0) {
                return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
            }
        }else {
            if (roleService.updateRole(sysRole) == 0) {
                return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
            }
        }
        return WebApiResult.buildSuccess(null);
    }

    @PostMapping("/addOrUpdatePermission")
    public WebApiResult addOrUpdatePermission(@RequestBody SysPermission permission) {
        if (permission.getId() == null || permission.getId() == 0) {
            permission.setId(null);
            if (permissionService.addPermission(permission) == 0) {
                return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
            }
        }else {
            if (permissionService.updatePermission(permission) == 0) {
                return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
            }
        }
        return WebApiResult.buildSuccess(null);
    }

    @GetMapping("/getPermissionList")
    public WebApiResult getPermissionList() {
        List<SysPermission> all = permissionService.getAll();
        return WebApiResult.buildSuccess(all);
    }

    @GetMapping("/getPermissionListByPage")
    public WebApiResult getPermissionListByPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Page<SysPermission> all = permissionService.getAllByPage(pageNum,pageSize);
        return WebApiResult.buildSuccess(all);
    }

    @DeleteMapping("/deletePermission")
    public WebApiResult deletePermission(@RequestParam Integer id) {
        if (permissionService.deletePermission(id) == 0) {
            return WebApiResult.build(WebApiResultCodeEnum.UNKNOWN_ERROR);
        }
        return WebApiResult.buildSuccess(null);
    }

    @PostMapping("/menuPermSave")
    public WebApiResult menuPermSave(@RequestBody MenuPermSaveParam param) {
        if (param == null) {
            return WebApiResult.build(WebApiResultCodeEnum.PARAM_IS_NULL);
        }
        roleService.deleteRPById(param.getRoleId());
        List<SysPermission> permissions = param.getPermissions();
        for (SysPermission permission : permissions) {
            roleService.insertRP(param.getRoleId(), permission.getId());
        }
        return WebApiResult.buildSuccess(null);
    }
}
