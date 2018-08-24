package com.cjh;

import com.cjh.dao.UserMapper;
import com.cjh.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
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
    /**
     * 动态查询 遍历数组
     */
    @org.junit.Test
    public   void  selectByArray(){
        int[] num={20,21,22};
        List<User> users = mapper.selectByArray(num);
        System.out.println(users);
    }
    /**
     * 动态查询 遍历集合
     */
    @org.junit.Test
    public   void  selectByList(){
        List<Integer> list=new ArrayList<>();
        list.add(20);
        List<User> users = mapper.selectByList(list);
        System.out.println(users);
    }
    /**
     * 新增许多用户
     */
    @org.junit.Test
    public   void  insertManyUser(){
        List<User> list=new ArrayList<>();
        User user1=new User();
        user1.setUserName("aaa");
        user1.setPassword("1");
        User user2=new User();
        user2.setUserName("bbb");
        user2.setPassword("1");
        User user3=new User();
        user3.setUserName("ccc");
        user3.setPassword("1");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        int num = mapper.insertManyUser(list);
        System.out.println(num);
    }
}
