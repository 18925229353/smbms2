package com.szxs.service;

import com.szxs.entity.SmbmsRole;

import java.util.List;

public interface SmbmsRoleService {
    /**
     * 查询全部角色信息
     * @return
     */
    List<SmbmsRole> queryAllRole();
}
