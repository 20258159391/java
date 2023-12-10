package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String id;
    private String username;
    private String passwd;
    private String email;
    private String phonenum;
    private int dormitory_id;//宿舍楼号
    private String college;//学院
    private int user_type;//用户类型
    private String uname;//用户昵称
    private String user_sculpture;//用户头像存储路径
}
