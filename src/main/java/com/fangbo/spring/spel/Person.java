package com.fangbo.spring.spel;

public class Person {
    private String name;
    //    private Address address;
    //    调用Address类中的city属性

    private String city;
    //    通过car的price确定info的等级
    private String info;
    private Car car;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", info='" + info + '\'' +
                ", car=" + car +
                '}';
    }

}
