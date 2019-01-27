package com.fangbo.spring.helloworld;

import java.util.List;

public class PersonList {
    private String name;
    private int age;
    private List<Car> cars;
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCar(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "PersonList{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Car> getCars() {
        return cars;
    }
}
