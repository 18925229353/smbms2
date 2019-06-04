package com.szxs.controller;

import com.szxs.entity.Smbms_User;
import com.szxs.service.Smbms_UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Resource
    private Smbms_UserService smbms_userService;//创建用户业务层

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpSession session, String userCode, String userPassword) {
        Smbms_User user = smbms_userService.loginByUserNameAndPwd(userCode, userPassword);
        if (user != null) {
            session.setAttribute("userSession", user);
            return "jsp/frame";
        }
        throw new ArithmeticException("用户名或密码不正确!");
    }

}
