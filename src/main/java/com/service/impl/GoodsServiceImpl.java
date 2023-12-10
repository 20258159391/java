package com.service.impl;

import com.dao.GoodsMapper;
import com.pojo.Goods;
import com.pojo.Orders;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.addGoods(goods);
    }

    @Override
    public int updateGoods_suid(String id) {

        return goodsMapper.updateGoods_suid(id);
    }

    @Override
    public List<Goods> getAllgoods() {

        return goodsMapper.getAllgoods();
    }

    @Override
    public int deleteGoods(String id) {

        return goodsMapper.deleteGoods(id);
    }

    @Override
    public List<Goods> getAllNosuidOrders() {
        return goodsMapper.getAllNosuidOrders();
    }

    @Override
    public List<Goods> getAllsuidOrders() {
        return goodsMapper.getAllsuidOrders();
    }
}
