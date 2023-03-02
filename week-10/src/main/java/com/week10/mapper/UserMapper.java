package com.week10.mapper;

import com.week10.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select count(*) from consumer")
    int getUserNum();//获取用户数量
    @Select("select count(*) from consumer where sex=#{sex}")
    int getManNum(int sex);// 获取男性用户数量
    @Select("select * from consumer where username=#{username}")
    User isExists(String username);//用户名是否存在
    @Select("select * from consumer where username=#{username}")
    User getUserByName(String username);//根据用户名查询用户
    List<User> getUserByIds(List<Integer> ids);// 根据ids批量查询用户
    int batchRemoveUser(List<Integer> ids);//批量删除
}
