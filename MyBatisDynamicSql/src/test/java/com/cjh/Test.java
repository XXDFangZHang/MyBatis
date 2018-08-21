package com.cjh;

import com.cjh.dao.UserMapper;
import com.cjh.pojo.User;
import com.cjh.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

import java.util.List;
import java.util.Scanner;

public class Test {
    static SqlSession session=null;
    static UserMapper mapper=null;
    static Scanner scanner=new Scanner(System.in);



    /**
     * 获取session 和 mapper赋值
     */
@Before
    public  void before(){
        session= SessionFactoryUtil.getSession();
        mapper=session.getMapper(UserMapper.class);
    }
    /**
     * 数据真正上传到数据库 和 关闭mapper
     */
@After
    public  void after(){
        session.commit();
        session.close();
    }
    /**
     * * 动态添加
     */
    @org.junit.Test
    public   void addUser(){
        User user=new User();
        user.setUserName("koko");
        user.setPassword("555");
        mapper.addUser(user);
        System.out.println(user.getId());


    }

    /**
     * 动态查询 if
     */
    @org.junit.Test
    public   void findUserByCondition(){
        User user=new User();
        user.setUserName("11");
        List<User> userByCondition = mapper.findUserByCondition(user);
        System.out.println(userByCondition);

    }
    /**
     * 动态修改
     */
    @org.junit.Test
    public  void updateUserByCondition(){
        User user=new User();
        user.setId(22);
        user.setUserName("wuwu");
        mapper.updateUserByCondition(user);

    }
    /**
     * 动态查询 choose when
     */
    @org.junit.Test
    public   void  chooseCondition(){
        User user=new User();
        user.setId(22);
        user.setUserName("11");
        List<User> chooseCondition = mapper.chooseCondition(user);
        System.out.println(chooseCondition);

    }
}
