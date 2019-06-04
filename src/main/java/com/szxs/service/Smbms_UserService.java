package com.szxs.service;

import com.szxs.entity.Smbms_User;
import com.szxs.utils.PageUtil;
import org.apache.ibatis.annotations.Param;

public interface Smbms_UserService {
    /**
     * 分页查询用户信息
     * @param currentPageNo
     * @param pageSize
     * @param smbms_User
     * @return
     */
    PageUtil<Smbms_User> querySmbms_User(int currentPageNo, int pageSize, Smbms_User smbms_User);

    /**
     * 登录
     * @param userCode
     * @param password
     * @return
     */
    Smbms_User loginByUserNameAndPwd(String userCode,String password);
    /**
     * 根据用户id查询信息
     * @param uId
     * @return
     */
    Smbms_User queryUserById(Integer uId);
    /**
     * 新增用户
     * @param smbms_user
     * @return
     */
    int insertSmbms_User(Smbms_User smbms_user);
    /**
     * 根據id刪除用戶
     * @param smbms_user
     * @return
     */
    int deleteSmbms_User(Smbms_User smbms_user);
    /**
     * 修改用户信息
     * @param smbms_user
     * @return
     */
    int updateSmbms_User(Smbms_User smbms_user);

    /**
     * 检查用户编码是否存在
     * @param smbms_user
     * @return
     */
    int checkUserCode(Smbms_User smbms_user);


    /**
     * 修改用户密码
     * @param newpassword
     * @return
     */
    int updateUserPwd(String newpassword, Integer id);
}
