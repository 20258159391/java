package com.dao;

import com.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int userAdd(User user);

    User selectUser(User user);

    List<User> getAllusers();

    int deleteUserByid(String id);

}
