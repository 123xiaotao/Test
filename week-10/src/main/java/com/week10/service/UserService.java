package com.week10.service;

import com.week10.mapper.UserMapper;
import com.week10.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public void batchRemoveUser(List<Integer> ids){
        userMapper.batchRemoveUser(ids);
    };//批量删除

    public int getUserNum(){
        return userMapper.getUserNum();
    };//获取用户数量
    public int getManNum(int sex){
        return userMapper.getManNum(sex);
    };// 获取男性用户数量
    public boolean isExists(String username){
        if (userMapper.isExists(username)!=null)
            return true;
        else return false;
    };//用户名是否存在
    public User getUserByName(String username){
        return userMapper.getUserByName(username);
    };//根据用户名查询用户
    public List<User> getUserByIds(List<Integer> ids){
        return userMapper.getUserByIds(ids);
    };// 根据ids批量查询用户
}
