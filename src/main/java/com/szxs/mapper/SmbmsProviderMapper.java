package com.szxs.mapper;

import com.szxs.entity.SmbmsProvider;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SmbmsProviderMapper {
    /**
     * 统计供应商表总记录数
     * @return
     */

   int querySumCount(@Param("pId") Integer pId);

    /**
     * 新增供应商表
     * @param smbmsProvider
     * @return
     */
    int insetSmbmsProvider(SmbmsProvider smbmsProvider);

    /**
     * 修改供应商表
     * @param smbmsProvider
     * @return
     */
    int updateSmbmsProvider(SmbmsProvider smbmsProvider);

    /**
     * 根据ProviderId删除供应商信息
     * * @param ProviderId
     * @return
     */
    int deleteProviderByid(@Param("pId") Integer pId);

    /**
     * 根据id查询供应商信息
     * @param pId
     * @return
     */
    SmbmsProvider queryProviderbyId(@Param("pId") Integer pId);

    /**
     * 根据供应商提供的id查询出相关信息及其所有的订单
     * @param id
     * @return
     */

    List<SmbmsProvider> getProviderById(@Param("id") Integer id);

    /**
     * 查询全部供应商
     * @return
     */
    List<SmbmsProvider> loadAllProvider();

    /**
     * 根据供应商编码，名称，联系人，创建时间(全部模糊查询)
     * @param proCode
     * @param proName
     * @param proContact
     * @param creationDate
     * @return
     */
    List<SmbmsProvider> getProvideByWhere(@Param("proCode") String proCode,
                                          @Param("proName") String proName,
                                          @Param("proContact") String proContact,
                                          @Param("creationDate") Date creationDate);

    /**
     * 查询订单总行数
     * @return
     */
    int queryTotalRows(@Param("smbmsProvider") SmbmsProvider smbmsProvider);

    /**
     * 查询供应商
     * @param currnetPageNO
     * @param pageSize
     * @param smbmsProvider
     * @return
     */
    List<SmbmsProvider> querySmbmsProviderPage(@Param("from") Integer currnetPageNO,
                                               @Param("pageSize") Integer pageSize,
                                               @Param("smbmsProvider") SmbmsProvider smbmsProvider);
}
