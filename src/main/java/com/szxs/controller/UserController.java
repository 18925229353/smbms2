package com.szxs.controller;

import com.szxs.entity.Smbms_User;
import com.szxs.entity.VoResponse;
import com.szxs.service.SmbmsRoleService;
import com.szxs.service.Smbms_UserService;
import com.szxs.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.awt.SunHints;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/*
用户
 */
@Controller
@RequestMapping("/sys")
public class UserController extends BaseController {
    @Resource
    private Smbms_UserService smbms_userService;//创建用户业务层
    @Resource
    private SmbmsRoleService smbmsRoleService;//创建角色业务层

    /**
     * 检查密码是否是当前登入的密码
     *
     * @return
     */
    @RequestMapping(value = "/pwdModifyUser",produces = "text/html;charset=utf-8")
    @ResponseBody
    public Object pwdModifyUser(Smbms_User user, HttpSession session, String oldpassword) {
        VoResponse voResponse=new VoResponse("false");
        Smbms_User smbms_user = (Smbms_User) session.getAttribute("userSession");
        if (smbms_user.getUserPassword().equals(oldpassword)) {
            voResponse.setResult("true");
        }
        return voResponse;
    }
    /**
     * 修改密码
     *
     * @return
     */
    @RequestMapping("/updatePwdUser")
    public String updatePwdUser(HttpSession session, String newpassword) {
        Smbms_User smbms_user = (Smbms_User) session.getAttribute("userSession");
        if (smbms_userService.updateUserPwd(newpassword, smbms_user.getId()) > 0) {
            smbms_user.setUserPassword(newpassword);
            return "jsp/frame";
        }
        return "jsp/pwdmodify";
    }
    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping("/queryAllUser")
    public String queryAllUser(@RequestParam(defaultValue = "1", required = false) Integer pageIndex, Smbms_User user, Model model) {
        model.addAttribute("roleList", smbmsRoleService.queryAllRole());
        model.addAttribute("userList", smbms_userService.querySmbms_User(pageIndex, 8, user));
        model.addAttribute("user", user);
        return "jsp/userlist";
    }
    /**
     * 查询单个用户
     */
    @RequestMapping(value="/viewUser/{id}")
    public String viewUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", smbms_userService.queryUserById(id));
        return "jsp/userview";
    }
    /**
     * 根据id删除用户
     */
    @RequestMapping(value = "/deleteUser/{id}")
    @ResponseBody
    public Object deleteUser(@PathVariable Integer id) {
        VoResponse voResponse=new VoResponse("false");
        if (smbms_userService.deleteSmbms_User(new Smbms_User(id)) > 0) {
            voResponse.setResult("true");
        }
        return voResponse;
    }
    /**
     * 根据id查看要修改的用户
     *
     * @return
     */
    @RequestMapping(value = "/modifyBeforeUser/{id}")
    public String modifyBeforeUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", smbms_userService.queryUserById(id));
        return "jsp/usermodify";
    }
    /**
     * 修改
     *
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(Smbms_User user, Model model, HttpSession session) {
        if (user != null) {
            Smbms_User userSession = (Smbms_User) session.getAttribute("userSession");
            user.setModifyBy(userSession.getId());
        }
        model.addAttribute("user", smbms_userService.updateSmbms_User(user));
        return "redirect:queryAllUser";
    }
    /**
     * 检查用户编码是否存在
     */
    @RequestMapping(value = "/checkCodeUser")
    @ResponseBody
    public Object checkCodeUser(Smbms_User user) {
        VoResponse voResponse=new VoResponse("false");
        int result = smbms_userService.checkUserCode(user);
        if (result > 0) {
            voResponse.setResult("exist");
            //存在
        }
        return voResponse;
    }
    /**
     * 添加用户
     *
     * @return
     */
    @RequestMapping("/addUser")
        public String addUser(@ModelAttribute Smbms_User user, Model model, MultipartFile userImgs, HttpSession session) {
        if (user != null) {
            Smbms_User smbms_user = (Smbms_User) session.getAttribute("userSession");
            user.setCreatedBy(smbms_user.getId());
        }
        String path=session.getServletContext().getRealPath("upfile");
        FileUtil.createDirectory(path);//创建目录
        File file=new File(path,userImgs.getOriginalFilename());
        user.setUserImg(userImgs.getOriginalFilename());
        try {
            userImgs.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("user", smbms_userService.insertSmbms_User(user));
        return "redirect:queryAllUser";
    }
}
