package org.lanqiao.jd.controller;

import org.lanqiao.jd.entity.User;
import org.lanqiao.jd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    /*将注册用户添加到数据库*/
    @RequestMapping("/insert")
    public int insert(User record) {
        String username = record.getUserName();
        if (userService.findByUserName(username) == null) {
            return userService.insert(record);
        } else {
            return 0;
        }
    }

    /*检查用户名是否存在*/
    @RequestMapping("/checkUserName")
    public boolean CheckUser(String userName) {
        return (userService.findByUserName(userName) == null);

    }

    /*检查手机号是否存在*/
    @RequestMapping("/checkTel")
    public boolean CheckTelephone(String telephone) {
        return (userService.selectByIphone(telephone) == null);
    }


    /*检查用户登录名与密码是否匹配,若匹配则设置一个cookie*/
    @RequestMapping("/checkUser")
    public boolean checkUser(HttpServletResponse response, User user) {
        boolean b = userService.checkUser(user.getUserName(), user.getPassword());
        if (b) {
            Cookie cookie = new Cookie("loginName", user.getUserName());
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return b;
    }

    /*更改用户登录状态*/
    @RequestMapping("/changeLoginStatus")
    public void changeLoginStatus(boolean userStatus, String loginName) {
        userService.changeLoginStatus(userStatus, loginName);
    }

    /*检查用户是否登录 */
    @RequestMapping("/checkUserStatus")
    public User checkUserStatus(String loginName) {
        return userService.checkUserStatus(loginName);
    }

//
//    public String abc(String account, String password, HttpSession session){
//        session.setAttribute("account",account);
//       return session.getAttribute("account");
//    }
}
