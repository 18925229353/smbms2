package com.szxs.controller;

import com.alibaba.fastjson.JSON;
import com.szxs.entity.SmbmsProvider;
import com.szxs.entity.Smbms_User;
import com.szxs.entity.VoResponse;
import com.szxs.service.SmbmsProviderService;
import com.szxs.service.impl.SmbmsProviderServiceImpl;
import com.szxs.utils.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
/*
供应商
 */
@Controller
@RequestMapping("/sys")
public class ProviderController extends BaseController{
    @Resource
   private SmbmsProviderService psBiz=new SmbmsProviderServiceImpl();//创建供应商业务层对象

        /*
         * 分页查询全部供应商信息
         * @return
         */
        @RequestMapping("/queryAllProvider")
         public String queryAllProvider(@RequestParam(defaultValue = "1",required = false)Integer pageIndex ,SmbmsProvider provider, Model model){
        model.addAttribute("providerList",psBiz.querySmbmsProvider(pageIndex, 8, provider));
        model.addAttribute("provider",provider);
        return "jsp/providerlist";
    }

        /**
         * 根据id查询单个供应商信息
         * @return
         */
        @RequestMapping(value="/viewProvider/{id}")
         public String viewProvider(@PathVariable Integer id, Model model){
            model.addAttribute("provider",psBiz.queryProviderbyId(id));
            return "jsp/providerview";
    }
        /**
         * 根据id删除供应商
         */
        @RequestMapping(value="/deleteProvider/{id}",produces = "text/html;charset=utf-8")
        @ResponseBody
        public Object deleteProvider(@PathVariable Integer id){
            VoResponse voResponse=new VoResponse("false");
            if(id!=null) {
                if (psBiz.deleteProviderByid(id)) {
                    voResponse.setResult("true");
                } else {
                    voResponse.setResult("" + psBiz.querySumCount(id) + "");
                }
            }
            return voResponse;
        }

        /**
         * 根据id查看要修改的供应商信息
         * @return
         */
        @RequestMapping(value="/modifyBeforeProvider/{id}")
        public String modifyBeforeProvider(@PathVariable Integer id,Model model){
            model.addAttribute("provider",psBiz.queryProviderbyId(id));
            return "jsp/providermodify";
        }

        /**
         * 修改供应商信息
         * @return
         */
        @RequestMapping(value="/updateProvider")
        public String updateProvider( SmbmsProvider provider, HttpSession session,Model model){
            if (provider != null) {
                Smbms_User smbms_user = (Smbms_User)session.getAttribute("userSession");
                provider.setModifyBy(smbms_user.getId());
            }
            model.addAttribute("provider", psBiz.updateSmbmsProvider(provider));
            return "redirect:queryAllProvider";
        }

        /**
         * 添加供应商信息
         * @return
         */
        @RequestMapping("/addProvider")
       public String addProvider(HttpSession session,SmbmsProvider provider){
       if(provider!=null){
           Smbms_User smbms_user = (Smbms_User)session.getAttribute("userSession");
           provider.setCreatedBy(smbms_user.getId());
       }
        psBiz.insetSmbmsProvider(provider);
             return "redirect:queryAllProvider";
    }

        /**
         * 加载所有供应商名称
         * @return
         */
        @RequestMapping(value="/loadAllProvider")
        @ResponseBody
       public Object loadAllProvider(){
           return psBiz.loadAllProvider();
        }

    }
