package org.lanqiao.jd.mapper;

import org.lanqiao.jd.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /*注册*/
    int insert(User record);

    String selectByIphone(String telephone);

    User findByUserName(String user_name);

    /*登录*/

    String checkUser(String userName);

     void changeLoginStatus(User user);

     User checkUserStatus(User user);
}