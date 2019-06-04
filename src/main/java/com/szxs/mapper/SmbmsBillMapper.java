package com.szxs.mapper;

import com.szxs.entity.SmbmsBill;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SmbmsBillMapper {
    /**
     * 根据商品名称（模糊查询），供应商（id）和是否付款 查询全部商品信息
     * @param smbmsBill
     * @return
     */
    public List<SmbmsBill> querySmbmsBill(SmbmsBill smbmsBill);

    /**
     * 指定多个供应商,获取供应商下的订单信息
     * @param ids
     * @return
     */
    public List<SmbmsBill> querySmbmsBillByids(Integer[] ids);

    /**
     * 根据订单编码(模糊查询)和指定的供应商列表（1-n个）获取相应的订单信息
     * @param conditionMap
     * @return
     */
    public List<SmbmsBill> querySmbmsBillByBillCodeAndids(Map<String, Object> conditionMap);

    /**
     * 查询订单总行数
     * @return
     */
    int queryTotalRows(@Param("smbmsBill") SmbmsBill smbmsBill);

    /**
     * 查询订单列表
     * @param currnetPageNO
     * @param pageSize
     * @param smbmsBill
     * @return
     */
    List<SmbmsBill> querySmbmsBillPage(@Param("from") Integer currnetPageNO,
                                       @Param("pageSize") Integer pageSize,
                                       @Param("smbmsBill") SmbmsBill smbmsBill);

    /**
     * 根据订单bId查询订单信息
     * @param bId
     * @return
     */
    public SmbmsBill querySmbmsBillByid(@Param("bId") Integer bId);

    /**
     * 根据订单bId删除订单信息
     * @param bId
     * @return
     */
    public int deleteSmbmsBillByid(@Param("bId") Integer bId);

    /**
     * 根据订单bId修改订单信息
     * @param smbmsBill
     * @return
     */
    public int updateSmbmsBillByid(SmbmsBill smbmsBill);

    /**
     * 添加订单信息
     * @param smbmsBill
     * @return
     */
    public int addSmbmsBill(SmbmsBill smbmsBill);
}
