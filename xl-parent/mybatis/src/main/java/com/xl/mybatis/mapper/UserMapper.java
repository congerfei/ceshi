package com.xl.mybatis.mapper;

import com.xl.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> getUserList();

    User getUserById(Integer id);

    void addUser(User user);

    int addUser2(User user);

    void deleteById(Integer id);

    void updateUser(User user);

}
