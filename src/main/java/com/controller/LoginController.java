package com.controller;

import com.pojo.Goods;
import com.pojo.User;
import com.service.GoodsService;
import com.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;

    //访问登录页面
    @RequestMapping("/lg")
    public String login(){
        return "login";
    }
    //密码校验
    @PostMapping("/selectUser")
    public String selectUser(User user, Model model){
//        System.out.println("controller"+user.toString());
        log.info("登录:{}",user);
        if (userService.selectUser(user)){
            if(user.getUser_type()==1){
                return "/index";
            }else {
                model.addAttribute("lguser",user);
                List<Goods> goodsList=goodsService.getAllsuidOrders();
                model.addAttribute("goods",goodsList);
//                System.out.println(goodsList.toString());
                return "/user_index";
            }
        }
        else
            return "login_v2";
    }

    //注册
    @PostMapping("/addUser")
    public String register(User user){
//        System.out.println(user.toString());
        if (userService.userAdd(user))
            return "login_v2";
        else return "register";
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }


}
