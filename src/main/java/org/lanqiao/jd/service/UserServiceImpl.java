package org.lanqiao.jd.service;

import org.lanqiao.jd.entity.User;
import org.lanqiao.jd.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /*注册*/
    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public User findByUserName(String user_name) {
        return userMapper.findByUserName(user_name);
    }

    @Override
    public String selectByIphone(String telephone) {
        return userMapper.selectByIphone(telephone);
    }

   /* 登录*/
    @Override
    public boolean checkUser(String userName, String password) {
        String loginName = userMapper.checkUser(userName);
        if (loginName != null && loginName.equals(password)) {
            changeLoginStatus(true, userName);
            return true;
        } else
            return false;
    }

    @Override
    public void changeLoginStatus(boolean userStatus, String loginName) {
        String regExEmail = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        Pattern pattern0 = Pattern.compile(regExEmail);
        Matcher matcher0 = pattern0.matcher(loginName);
        String regExTelephone = "^1[34578]\\d{9}$";
        Pattern pattern1 = Pattern.compile(regExTelephone);
        Matcher matcher1 = pattern1.matcher(loginName);
        if (matcher0.matches()) {
            userMapper.changeLoginStatus(new User(loginName, userStatus, ""));
        } else if (matcher1.matches()) {
            userMapper.changeLoginStatus(new User(loginName, userStatus, 0));
        } else {
            userMapper.changeLoginStatus(new User(loginName, userStatus));
        }

    }

    @Override
    public User checkUserStatus(String loginName) {
        String regExEmail = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        Pattern pattern0 = Pattern.compile(regExEmail);
        Matcher matcher0 = pattern0.matcher(loginName);
        String regExTelephone = "^1[34578]\\d{9}$";
        Pattern pattern1 = Pattern.compile(regExTelephone);
        Matcher matcher1 = pattern1.matcher(loginName);
        if (matcher0.matches()) {
            /*若UserStats为true,返回该对象*/
            User user = userMapper.checkUserStatus(new User(loginName, 0));
            if (user.isUserStatus())
                return (user);
            else return null;
        } else if (matcher1.matches()) {
            User user = userMapper.checkUserStatus(new User(loginName, ""));
            if (user.isUserStatus())
                return (user);
            else return null;
        } else {
            User user = userMapper.checkUserStatus(new User(loginName));
            if (user.isUserStatus())
                return (user);
            else return null;
        }


    }

}
