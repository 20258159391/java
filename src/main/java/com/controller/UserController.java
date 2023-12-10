package com.controller;

import com.pojo.Goods;
import com.pojo.User;
import com.service.GoodsService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;
    //管理员主页
    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping("/")
    public String user_index(Model model){
        List<Goods> goodsList=goodsService.getAllsuidOrders();
        model.addAttribute("goods",goodsList);
        return "user_index";
    }


//    @RequestMapping("/test")
//    public String test(Model m ){
//        SimpleDateFormat dateFormat = new SimpleDateFormat();
//        String s = dateFormat.format(new Date());
//        m.addAttribute("date",s);
//        return "/test :: #test";
//    }


    @RequestMapping("/allUser")
    public String getAllUsers(Model model){
        List<User> allusers = userService.getAllusers();
        model.addAttribute("users",allusers);
        for (User i:allusers
             ) {
            System.out.println(i.toString());
        }
        return "allUser";
    }

    @RequestMapping("/deleteUser")
    public String deleteUserByid(String id,Model model){
        System.out.println(id);
        int i = userService.deleteUserByid(id);
        List<User> allusers = userService.getAllusers();
        model.addAttribute("users",allusers);
        return "allUser";
    }




}
