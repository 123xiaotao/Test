package com.springboot2.control;

import com.springboot2.mapper.CityMapper;
import com.springboot2.pojo.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FormTestController {
    @Autowired
    CityMapper cityMapper;
   City city= new City(50,"20");
    @GetMapping("/test1")
    @ResponseBody
    public String ff(){
     cityMapper.insert(city);
        return "成功";
    }


    @GetMapping("/test")
    @ResponseBody
    public String ff(@RequestParam("id") Integer id){
        City fun = cityMapper.fun(id);
        return fun.toString();

    }
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form_layouts";
    }
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息：email={}，username={}，headerImg={}，photos={}",
                email,username,headerImg.getSize(),photos.length);

        if(!headerImg.isEmpty()){
            //保存到文件服务器，OSS服务器
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\cache\\"+originalFilename));
        }

        if(photos.length > 0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\cache\\"+originalFilename));
                }
            }
        }


        return "index";
    }
}
