package com.service.impl;

import com.dao.OrdersMapper;
import com.pojo.Orders;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrderService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public List<Orders> getAllOrders() {
        List<Orders> allOrders = ordersMapper.getAllOrders();
        return allOrders;
    }

    @Override
    public int deleteOrderByid(String id) {

        return ordersMapper.deleteOrderByid(id);
    }
}
