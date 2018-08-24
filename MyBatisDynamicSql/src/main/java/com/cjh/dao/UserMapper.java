package com.cjh.dao;

import com.cjh.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface UserMapper {
    /**
     * 新增用户
     */
    int addUser(User user);

    /**
     * 动态查询 if
     * */
    List<User> findUserByCondition(User user);
    /**
     * 动态修改
     * */
    void updateUserByCondition(User user);
    /**
     * 动态查询 choose  when
     * */
    List<User> chooseCondition(User user);
    /**
     * 动态查询 遍历数组
     * */
    List<User> selectByArray(int[] num);
    /**
     * 动态查询 遍历数组ww
     * */
    List<User> selectByList(List<Integer> list);
    /**
     * 新增许多用户
     */
    int insertManyUser(List<User> list);


}
