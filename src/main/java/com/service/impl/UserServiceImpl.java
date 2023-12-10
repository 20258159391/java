package com.service.impl;

import com.dao.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean userAdd(User user) {

        try{
            userMapper.userAdd(user);
            System.out.println(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean selectUser(User user) {
        try{
            User user1=userMapper.selectUser(user);
            System.out.println("user1:"+user1.toString());
            if (user.getPasswd().equals(user1.getPasswd()))
            return  true;
            else
                return false;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public List<User> getAllusers() {
        try {
            List list=userMapper.getAllusers();
            return list;
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public int deleteUserByid(String id) {
       int i= userMapper.deleteUserByid(id);
       if (i==1)
           return 1;
       else
           return 0;
    }
}
