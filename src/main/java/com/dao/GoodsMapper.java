package com.dao;

import com.pojo.Goods;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GoodsMapper {

    //获取用户界面显示的商品总数
    long count();
    //添加商品
    int addGoods(Goods goods);
    //添加商品照片
    int addImage(Goods goods);
    //更新商品为已审核状态
    int updateGoods_suid(String id);
    //删除商品
    int deleteGoods(String id);

    List<Goods> getAllgoods();
    List<Goods> getAllNosuidOrders();

    List<Goods> getAllsuidOrders();
}
