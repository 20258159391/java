package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private String id;
    private String goods_name;
    private String goods_info;
    private float goods_price;
    private String list_date;
    private String owner_username;
//    private String sell;//标识是否已售出//后面利用触发器，购买的时候逻辑删除
    private int su_id;//审核标识01
    private String image_url;

}
