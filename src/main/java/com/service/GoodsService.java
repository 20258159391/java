package com.service;

import com.pojo.Goods;


import java.util.List;

public interface GoodsService {
    int addGoods(Goods goods);

    int updateGoods_suid(String id);
    List<Goods> getAllgoods();
    int deleteGoods(String id);
    List<Goods> getAllNosuidOrders();

    List<Goods> getAllsuidOrders();
}
