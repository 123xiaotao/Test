package com.springboot2.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Crontrol1 {
    @GetMapping("/aaa.jpg")
    public String hello(){
        return "aaa";
    }
    @RequestMapping("/int/{id}/{username}")
    public Map<String,Object> map(@PathVariable("id") Integer id, @PathVariable("username") String name){
        Map<String,Object> map=new HashMap<>();
        map.put(name,id);
        return  map;

    }
}
