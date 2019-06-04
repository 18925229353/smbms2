package com.szxs.service.impl;

import com.szxs.entity.SmbmsBill;
import com.szxs.mapper.SmbmsBillMapper;
import com.szxs.service.SmbmsBillService;
import com.szxs.utils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class SmbmsBillServiceImpl implements SmbmsBillService {
    @Resource
   private SmbmsBillMapper smbmsBillMapper;
    public PageUtil<SmbmsBill> querySmbmsBill(int currentPageNo, int pageSize, SmbmsBill smbmsBill) {
        PageUtil<SmbmsBill> pageUtil=new PageUtil<SmbmsBill>();
        pageUtil.setCurrentPageNo(currentPageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setTotalRows(smbmsBillMapper.queryTotalRows(smbmsBill));
        pageUtil.setTotalPage((pageUtil.getTotalRows()+pageSize-1)/pageSize);
        pageUtil.setDateList(smbmsBillMapper.querySmbmsBillPage((currentPageNo-1)*pageSize,pageSize,smbmsBill));
        return pageUtil;
    }

    public SmbmsBill querySmbmsBillByid(Integer bId) {
        return smbmsBillMapper.querySmbmsBillByid(bId);
    }

    public int deleteSmbmsBillByid(Integer bId) {
        return smbmsBillMapper.deleteSmbmsBillByid(bId);
    }

    public int updateSmbmsBillByid(SmbmsBill smbmsBill) {
        smbmsBill.setModifyDate(new Date());
        return smbmsBillMapper.updateSmbmsBillByid(smbmsBill);
    }

    public int addSmbmsBill(SmbmsBill smbmsBill) {
        return smbmsBillMapper.addSmbmsBill(smbmsBill);
    }
}
