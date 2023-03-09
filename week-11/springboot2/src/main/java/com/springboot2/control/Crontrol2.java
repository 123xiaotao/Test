package com.springboot2.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Crontrol2 {
    @RequestMapping("/control2")
    public String fun(Model model){
        model.addAttribute("msg","你好小白");
        model.addAttribute("link", "https://www.baidu.com");
        return "/success";
    }
}
