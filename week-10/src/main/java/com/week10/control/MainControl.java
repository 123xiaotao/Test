package com.week10.control;

import com.week10.pojo.User;
import com.week10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainControl {
    @Autowired
    UserService userService;
    @ResponseBody
    @GetMapping("/getUserNum")
    public String fun(){
        int userNum = userService.getUserNum();
        System.out.println(userNum);
        return "获取用户数量成功";
    }
    @ResponseBody
    @GetMapping("/getManNum")
    public String fun1(){
        int userNum = userService.getManNum(1);
        System.out.println(userNum);
        return "获取男性用户数量成功"+userNum;
    }
    @ResponseBody
    @GetMapping("/isExists")
    public String fun2(){
        boolean exists = userService.isExists("2");
        System.out.println(exists);
        return "获取男性用户数量成功"+exists;
    }
    @ResponseBody
    @GetMapping("/getUserByName")
    public String fun3(){
        User userByName = userService.getUserByName("2");
        return "获取男性用户数量成功"+userByName;
    }
}
