package com.atguigu.servicecms.controller;


import com.atguigu.servicecms.service.CrmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2023-04-25
 */
@RestController
@RequestMapping("/servicecms/crm-banner")
public class CrmBannerController {
    @Autowired
    CrmBannerService crm1;
    @RequestMapping("/123")
    public String fun(){
        return crm1.select().toString();
    }
//    @RequestMapping("/1234")
//    public String fun1(){
//        return crm.select().toString();
//    }
}

