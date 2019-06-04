package com.szxs.mapper;

import com.szxs.entity.Smbms_User;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public interface SmbmsUserMapper{
    /**
     * 查询全部用户信息
     * @return
     */
    List<Smbms_User> queryAllSmbmsUsers();

    /**
     * 根据用户id查询信息
     * @param uId
     * @return
     */
    Smbms_User queryUserById(@Param("uId") Integer uId);
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
     * 修改用户密码
     * @param newpassword
     * @return
     */
    int updateUserPwd(@Param("newpassword")String newpassword,@Param("id") Integer id);

    /**
     * 检查用户编码是否存在
     * @param smbms_user
     * @return
     */
    int checkUserCode(Smbms_User smbms_user);
    /**
     * 登录
     * @param smbms_user
     * @return 条件
     */
    Smbms_User loginByUserNameAndPwd(Smbms_User smbms_user);

    /**
     * 查询用户总行数
     * @return
     */
    int queryTotalRows(@Param("smbms_user") Smbms_User smbms_user);

    /**
     * 查询用户信息
     * @param currnetPageNO
     * @param pageSize
     * @param smbms_user
     * @return
     */
    List<Smbms_User> querySmbms_UserPage(@Param("from") Integer currnetPageNO,
                                         @Param("pageSize") Integer pageSize,
                                         @Param("smbms_user") Smbms_User smbms_user);

}
