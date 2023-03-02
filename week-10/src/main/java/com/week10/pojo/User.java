package com.week10.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    int id;
    String username;
    String password;
    int sex;
    String phone_num;
    String email;
    Date birth;
    String introduction;
    String location;
    String avato;
    Date create_time;
    Date update_time;

}
