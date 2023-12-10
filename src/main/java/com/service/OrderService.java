package com.service;

import com.pojo.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> getAllOrders();
    int deleteOrderByid(String id);
}
