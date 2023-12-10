package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private String id;
    private String username;//下单用户
    private String goods_name;
    private float goods_price;
    private String list_date;

}
