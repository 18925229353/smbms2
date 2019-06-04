package com.szxs.controller;

import com.szxs.entity.SmbmsBill;
import com.szxs.entity.SmbmsProvider;
import com.szxs.entity.Smbms_User;
import com.szxs.entity.VoResponse;
import com.szxs.service.SmbmsBillService;
import com.szxs.service.SmbmsProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
/*
订单
 */
@Controller
@RequestMapping("/sys")
public class BillController extends BaseController {
    @Resource
    private SmbmsBillService smbmsBillService;
    @Resource
    private SmbmsProviderService smbmsProviderService;

  /*
     * 查询全部订单信息
     * @return
     */
    @RequestMapping("/queryAllBill")
    public String queryAllBill(@RequestParam(defaultValue = "1",required = false)Integer pageIndex , SmbmsBill bill, Model model){
        model.addAttribute("providerList",smbmsProviderService.loadAllProvider());
        model.addAttribute("billList",smbmsBillService.querySmbmsBill(pageIndex,6,bill));
        model.addAttribute("bill",bill);
        return "jsp/billlist";
    }

    /**
     * 查看个人订单信息
     * @return
     */
    @RequestMapping(value=("/viewBill/{id}"))
    public String viewBill(@PathVariable Integer id, Model model){
        model.addAttribute("bill",smbmsBillService.querySmbmsBillByid(id));
        return "jsp/billview";
    }

    /**
     * 删除订单
     * @return
     */
    @RequestMapping(value="/deleteBill/{id}")
    @ResponseBody
    public Object deleteBill(@PathVariable Integer id){
        VoResponse voResponse=new VoResponse("false");
        String result="{\"delResult\":\"false\"}";
            if(smbmsBillService.deleteSmbmsBillByid(id)>0){
                voResponse.setResult("true");
            }
        return voResponse;
    }
    /**
     * 根据id查看要修改的个人信息
     */
    @RequestMapping("/modifyBeforeBill/{id}")
    public String modifyBeforeBill(@PathVariable Integer id,Model model,SmbmsBill bill){
        model.addAttribute("bill",smbmsBillService.querySmbmsBillByid(id));
        return "jsp/billmodify";
    }
    /**
     * 修改订单信息
     * @return
     */
    @RequestMapping("/updateBill")
    public String updateBill(SmbmsBill bill, HttpSession session,Model model){
        if(bill!=null){
            Smbms_User smbms_user = (Smbms_User)session.getAttribute("userSession");
            bill.setModifyBy(smbms_user.getId());
        }
        model.addAttribute("bill",smbmsBillService.updateSmbmsBillByid(bill));
        return "redirect:queryAllBill";
    }

    /**
     * 添加订单
     * @return
     */
    @RequestMapping("/addBill")
    public String addBill(SmbmsBill bill,HttpSession session,Model model){
        if(bill!=null){
            Smbms_User smbms_user=(Smbms_User)session.getAttribute("userSession");
            smbms_user.setCreatedBy(bill.getId());
        }
        model.addAttribute("bill",smbmsBillService.addSmbmsBill(bill));
        return  "redirect:queryAllBill";
  }
}
