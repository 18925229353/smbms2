package com.szxs.service.impl;

import com.szxs.entity.SmbmsRole;
import com.szxs.mapper.SmbmsRoleMapper;
import com.szxs.service.SmbmsBillService;
import com.szxs.service.SmbmsRoleService;
import com.szxs.utils.MybatisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SmbmsRoleServiceImpl implements SmbmsRoleService {
    @Resource
    private SmbmsRoleMapper smbmsRoleMapper;
    public List<SmbmsRole> queryAllRole() {
        return smbmsRoleMapper.queryAllRole();
    }
}
