package com.springboot2.control;

import com.springboot2.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class Control3 {
    @GetMapping(value = {"/","/login"})
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String main( User user, HttpSession session, Model model){ //RedirectAttributes
        if(StringUtils.hasLength(user.getUsername()) && "123456".equals(user.getPassword())){
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.html;  重定向防止表单重复提交
            return "redirect:/main";
        }else {
            model.addAttribute("msg","账号密码错误");
            //回到登录页面
            return "login";
        }

    }
    @GetMapping("/main")
    public String mainPage(HttpSession session, Model model){

        //最好用拦截器,过滤器
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null){
            return "/index";
        }else {
            //session过期，没有登陆过
            //回到登录页面
            model.addAttribute("msg","请重新登录");
            return "login";
        }
    }

}
