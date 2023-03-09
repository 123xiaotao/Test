package com.springboot2.pojo;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class City {
    Integer id;
    String name;

    public City(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public City() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
