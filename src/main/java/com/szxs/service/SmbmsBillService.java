package com.szxs.service;

import com.szxs.entity.SmbmsBill;
import com.szxs.utils.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmbmsBillService {
    /**
     * 订单分页查询
     * @param currentPageNo
     * @param pageSize
     * @param smbmsBill
     * @return
     */
    PageUtil<SmbmsBill> querySmbmsBill(int currentPageNo, int pageSize, SmbmsBill smbmsBill);


    /**
     * 根据订单bId查询订单信息
     * @param bId
     * @return
     */
    public SmbmsBill querySmbmsBillByid(Integer bId);


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
