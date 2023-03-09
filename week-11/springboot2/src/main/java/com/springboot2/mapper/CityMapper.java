package com.springboot2.mapper;

import com.springboot2.pojo.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CityMapper {
    @Select("select * from test0 where id=#{id}")
    public City fun(Integer id);
    public void insert(City city);
    @Select("select * from test0")
    public List<City> fun1();
}
