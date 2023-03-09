package com.springboot2.control;

import com.springboot2.mapper.CityMapper;
import com.springboot2.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TableControl {
    @Autowired
    CityMapper cityMapper;
    @GetMapping("/basic_table")
    public String fun(){
        return "basic_table";
    }
    @GetMapping("/dynamic_table")
    public String fun1(Model model){
        List<City> cities = cityMapper.fun1();
        model.addAttribute("users",cities);
        return "dynamic_table";
    }
    @GetMapping("/responsive_table")
    public String fun2(){
        return "responsive_table";
    }
    @GetMapping("/editable_table")
    public String fun3(){
        return "editable_table";
    }
}
