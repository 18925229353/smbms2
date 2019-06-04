package com.szxs.service;

import com.szxs.entity.SmbmsProvider;
import com.szxs.utils.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmbmsProviderService {
    /**
     * 供应商分页查询
     * @param currentPageNo
     * @param pageSize
     * @param smbmsProvider
     * @return
     */
    PageUtil<SmbmsProvider> querySmbmsProvider(int currentPageNo, int pageSize, SmbmsProvider smbmsProvider);

    /**
     * 新增供应商表
     * @param smbmsProvider
     * @return
     */
    int insetSmbmsProvider(SmbmsProvider smbmsProvider);

    /**
     * 根据id查询供应商信息
     * @param pId
     * @return
     */

    SmbmsProvider queryProviderbyId(Integer pId);
    /**
     * 根据ProviderId删除供应商信息
     * * @param ProviderId
     * @return
     */
    boolean deleteProviderByid( Integer pId);
    /**
     * 修改供应商表
     * @param smbmsProvider
     * @return
     */
    int updateSmbmsProvider(SmbmsProvider smbmsProvider);
    /**
     * 查询全部供应商
     * @return
     */
    List<SmbmsProvider> loadAllProvider();
    /**
     * 统计供应商表总记录数
     * @return
     */

    int querySumCount(@Param("pId") Integer pId);

}
