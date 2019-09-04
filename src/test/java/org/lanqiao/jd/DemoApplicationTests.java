package org.lanqiao.jd;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.lanqiao.jd.entity.User;
import org.lanqiao.jd.mapper.UserMapper;

import java.io.Reader;

public class DemoApplicationTests {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-Config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User a = userMapper.selectByPrimaryKey(1);
			System.out.println(a);
            /*int a = userMapper.insert(new User("zhangsan1234", "zs1234", "13003911056", "1932199890@qq.com"));
            session.commit();
            System.out.println(a);*/
			/*String s = userMapper.checkUser("张无忌");
			System.out.println(s);*/


           /* ClassesMapper classesMapper=session.getMapper(ClassesMapper.class);
            Classes classes=classesMapper.getClassesBytid(2);

            System.out.println(classes);*/

            /*ClassesMapper classesMapper=session.getMapper(ClassesMapper.class);
            Classes classes=classesMapper.getClasses(2);
            System.out.println(classes);*/

//            UsersMapper userDao = session.getMapper(UsersMapper.class);
           /*List<Users> list = userDao.getAllUser();
            for (Users a:list
                    ) {
                System.out.println(a);

            }*/

//            boolean a = userDao.checkUser(new Users("333", "232323"));
           /* boolean a = userDao.checkUser(new Users("李强", "121212"));
            System.out.println(a);*/
           /* Users users = userDao.selectByPrimaryKey(4);
            System.out.println(users);*/
        } finally {
            session.close();
        }
    }

}
