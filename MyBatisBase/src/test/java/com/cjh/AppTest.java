package com.cjh;

import com.cjh.dao.UserMapper;
import com.cjh.pojo.User;
import org.apache.ibatis.session.SqlSession;

import org.junit.Test;

import java.util.List;
import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    static SqlSession  session=null;
    static UserMapper mapper=null;
    static Scanner scanner=new Scanner(System.in);
    static String uname;
    public static void main(String[] args) {
        login();
    }
    /**
     * 登录
     */
    public static  void login(){
        before();
        System.out.println("请输入姓名：");
        String name = scanner.next();
        System.out.println("请输入密码：");
        String pwd = scanner.next();
        int login = mapper.Login(name, pwd);
        if (login>0){
            uname=name;
            mean();
        }else{
            System.out.println("登录失败！请重新登录！");
            login();
        }

    }
    /**
     * 菜单
     */

    public static  void mean(){
        System.out.println("*******************"+"欢迎"+uname+"******************");
        System.out.println("1.添加");
        System.out.println("2.修改");
        System.out.println("3.删除");
        System.out.println("4.按ID查询");
        System.out.println("5.全部查询");
        System.out.println("0.退出");
        int num = scanner.nextInt();
        switch (num){
            case 1:
                testAddMapper();
                break;
            case 2:
                updateUser();
                break;
            case 3:
                deleteUser();
                break;
            case 4:
                selectById();
                break;
            case 5:
                selectAll();
                break;
            case 0:
                break;
        }

    }
    /**
     * 获取session 和 mapper赋值
     */

    public static void before(){
        session= SessionFactoryUtil.getSession();
        mapper=session.getMapper(UserMapper.class);
    }
    /**
     * 数据真正上传到数据库 和 关闭mapper
     */

    public static void after(){
        session.commit();
        session.close();
    }
    /**
     * 添加
     */
    @Test
    public static void  testAddMapper()
    {
        before();
        System.out.println("姓名：");
        String name = scanner.next();
        System.out.println("密码：");
        String pwd = scanner.next();
        User user=new User(name,pwd);
        int num = mapper.addUser(user);
        System.out.println(user.getId());
        if (num>0){
            System.out.println("新增成功");
        }else{
            System.out.println("新增失败");
        }
        after();
        mean();
    }
    /**
     * 修改
     */
    @Test
    public static  void  updateUser(){
        before();
        System.out.println("需要修改的用户ID：");
        int id = scanner.nextInt();
        System.out.println("修改姓名：");
        String name = scanner.next();
        System.out.println("修改密码：");
        String pwd = scanner.next();
        User  user=new User(id,name,pwd);
        int num = mapper.updateUser(user);
        if (num>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        after();
        mean();
    }
    /**
     * 删除
     */
    @Test
    public static void  deleteUser(){
        before();
        System.out.println("删除用户的ID：");
        int id = scanner.nextInt();
        int num = mapper.deleteUser(id);

        if (num>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        after();
        mean();
    }
    /**
     * 查询指定的User
     */
    @Test
    public static void   selectById(){
        before();
        System.out.println("查询用户的ID：");
        int id = scanner.nextInt();
        User user=   mapper.selectUserById(id);
        System.out.println(user);
        after();
        mean();
    }
    /**
     * 查询所有的User
     */
    @Test
    public static void   selectAll(){
        before();
        List<User> user=   mapper.selectAllUsers();
        System.out.println(user);
        after();
        mean();
    }
}
