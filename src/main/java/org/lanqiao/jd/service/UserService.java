package org.lanqiao.jd.service;

import org.lanqiao.jd.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    /*注册*/
    public int insert(User record);

    public String selectByIphone(String telephone);

    public User findByUserName(String user_name);

    /*登录*/

    public boolean checkUser(String userName, String password);

    public void changeLoginStatus(boolean userStatus, String loginName);

    public User checkUserStatus(String loginName);
}
