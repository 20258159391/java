package com.controller;

import com.pojo.Orders;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("/orders")
@Controller
public class OrdersController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/allOrders")
    public String getAllOrders(Model model){
        List<Orders> allOrders = orderService.getAllOrders();
        for (Orders o:allOrders
             ) {
            System.out.println(o.toString());
        }
        model.addAttribute("oders",allOrders);
        return "showorders";
    }

    @RequestMapping("/deleteorder/{id}")
    public String deleteOrderByid(@PathVariable String id,Model m){
        System.out.println(id);
       int del=orderService.deleteOrderByid(id);
       if (del>0){
            m.addAttribute("data",del);
       }
        return "redirect:/orders/allOrders";
    }
}
