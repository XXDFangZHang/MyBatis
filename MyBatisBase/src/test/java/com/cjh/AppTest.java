package com.cjh;

import com.cjh.dao.UserMapper;
import com.cjh.pojo.User;
import com.cjh.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    SqlSession session=null;
    UserMapper mapper=null;
    @Before
    public void before(){
        session= SessionFactoryUtil.getSession();
        mapper=session.getMapper(UserMapper.class);
    }

    @After
    public void after(){
        session.commit();
        session.close();
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAddMapper()
    {
        User user=new User("U2测试","846");
        int num = mapper.addUser(user);
        if (num>0){
            System.out.println("新增成功");
        }else{
            System.out.println("新增失败");
        }
    }
    @Test
    public  void  updateUser(){
        User  user=new User(15,"小黑黑","adminssss");
        int num = mapper.updateUser(user);
        if (num>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }
    /**
     * 删除
     */
    @Test
    public  void  deleteUser(){
        int num = mapper.deleteUser(17);

        if (num>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }
    /**
     * 查询指定的User
     */
    @Test
    public  void   selectById(){
        User user=   mapper.selectUserById(18);
        System.out.println(user);
    }
    /**
     * 查询所有的User
     */
    @Test
    public  void   selectAll(){
        List<User> user=   mapper.selectAllUsers();
        System.out.println(user);
    }
}
