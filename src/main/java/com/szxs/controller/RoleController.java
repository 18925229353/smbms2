package com.szxs.controller;
import com.szxs.service.SmbmsRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/*
角色
 */
@RestController
public class RoleController{
    @Resource
    private SmbmsRoleService smbmsRoleService;
    /**
     * 加载所有角色名称
     * @return
     */
    @RequestMapping(value = "/loadJosnRole")
    public Object loadJosnRole(){
        return  smbmsRoleService.queryAllRole();
    }
}
