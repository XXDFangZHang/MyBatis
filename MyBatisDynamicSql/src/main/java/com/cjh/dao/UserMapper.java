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
}
