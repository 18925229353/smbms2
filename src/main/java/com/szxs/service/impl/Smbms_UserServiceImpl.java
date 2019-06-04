package com.szxs.service.impl;

import com.szxs.entity.Smbms_User;
import com.szxs.mapper.SmbmsUserMapper;
import com.szxs.service.Smbms_UserService;
import com.szxs.utils.MybatisUtil;
import com.szxs.utils.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
@Service
public class Smbms_UserServiceImpl implements Smbms_UserService {
    @Resource
    private SmbmsUserMapper  userMapper;
    public PageUtil<Smbms_User> querySmbms_User(int currentPageNo, int pageSize, Smbms_User smbms_User) {
        PageUtil<Smbms_User> page=new PageUtil<Smbms_User>();
        page.setCurrentPageNo(currentPageNo);
        page.setPageSize(pageSize);
        page.setTotalRows(userMapper.queryTotalRows(smbms_User));
        page.setTotalPage((page.getTotalRows()+pageSize-1)/pageSize);
        page.setDateList(userMapper.querySmbms_UserPage((currentPageNo-1)*pageSize,pageSize,smbms_User));
        return page;
    }
    public Smbms_User loginByUserNameAndPwd(String userCode, String password) {
        return   userMapper.loginByUserNameAndPwd(new Smbms_User(userCode,password));
    }

    public Smbms_User queryUserById(Integer uId) {
        return userMapper.queryUserById(uId);
    }

    public int insertSmbms_User(Smbms_User smbms_user) {

        return userMapper.insertSmbms_User(smbms_user);
    }

    public int deleteSmbms_User(Smbms_User user) {
        return userMapper.deleteSmbms_User(user);
    }

    public int updateSmbms_User(Smbms_User smbms_user) {
        smbms_user.setModifyDate(new Date());
        return userMapper.updateSmbms_User(smbms_user);
    }

    public int checkUserCode(Smbms_User smbms_user) {
        return userMapper.checkUserCode(smbms_user);
    }

    public int updateUserPwd(String newpassword,Integer id) {
        return userMapper.updateUserPwd(newpassword,id);
    }

}
