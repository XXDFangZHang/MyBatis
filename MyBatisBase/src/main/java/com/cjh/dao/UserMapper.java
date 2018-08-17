package com.cjh.dao;

import com.cjh.pojo.User;

import java.io.Serializable;
import java.util.List;

public interface UserMapper {
    /**
     * 新增用户
     */
    int addUser(User user);
    /**
     * 修改用户
     */
    int updateUser(User user);
    /**
     * 删除用户
     */
    int deleteUser(Serializable id);
    /**
     * 用ID查询用户
     */
     User  selectUserById(Serializable id);
    /**
     * 查询所有
     */
    List<User> selectAllUsers();
}
