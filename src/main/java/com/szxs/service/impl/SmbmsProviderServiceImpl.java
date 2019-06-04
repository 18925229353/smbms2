package com.szxs.service.impl;

import com.szxs.entity.SmbmsProvider;
import com.szxs.mapper.SmbmsProviderMapper;
import com.szxs.service.SmbmsProviderService;
import com.szxs.utils.MybatisUtil;
import com.szxs.utils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class SmbmsProviderServiceImpl implements SmbmsProviderService {
    @Resource
    private  SmbmsProviderMapper  smbmsProviderMapper ;
    public PageUtil<SmbmsProvider> querySmbmsProvider(int currentPageNo, int pageSize, SmbmsProvider smbmsProvider) {
        PageUtil<SmbmsProvider> pageUtil=new PageUtil<SmbmsProvider>();
        pageUtil.setCurrentPageNo(currentPageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setTotalRows(smbmsProviderMapper.queryTotalRows(smbmsProvider));
        pageUtil.setTotalPage((pageUtil.getTotalRows()+pageSize-1)/pageSize);
        pageUtil.setDateList(
                smbmsProviderMapper.querySmbmsProviderPage(
                        (currentPageNo-1)*pageSize,
                        pageSize,
                        smbmsProvider));
        return  pageUtil;
    }

    public int insetSmbmsProvider(SmbmsProvider smbmsProvider) {
        return  smbmsProviderMapper.insetSmbmsProvider(smbmsProvider);
    }

    public SmbmsProvider queryProviderbyId(Integer pId) {
        return smbmsProviderMapper.queryProviderbyId(pId);
    }

    public boolean deleteProviderByid(Integer pId) {
        //查询返回的行数
        Integer count=this.querySumCount(pId);
        //判断供应商下是否有订单
        if(null!=count&&count>0){
            return false;
        }else{
            if(smbmsProviderMapper.deleteProviderByid(pId)>0){
                return true;
            }else{
                return false;
            }
        }
    }
    public int querySumCount(Integer pId) {

        return smbmsProviderMapper.querySumCount(pId);
    }

    public int updateSmbmsProvider(SmbmsProvider smbmsProvider) {
        smbmsProvider.setModifyDate(new Date());
        return smbmsProviderMapper.updateSmbmsProvider(smbmsProvider);
    }

    public List<SmbmsProvider> loadAllProvider() {
        return smbmsProviderMapper.loadAllProvider();
    }


}
