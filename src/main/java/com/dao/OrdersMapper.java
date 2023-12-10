package com.dao;

import com.pojo.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrdersMapper {

    int deleteOrderByid(String id);
    List<Orders> getAllOrders();


}
