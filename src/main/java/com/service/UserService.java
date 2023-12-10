package com.service;

import com.pojo.Orders;
import com.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    //用户操作
    boolean userAdd(User user);
    boolean selectUser(User user);
    List<User> getAllusers();

    int deleteUserByid(String id);

}
