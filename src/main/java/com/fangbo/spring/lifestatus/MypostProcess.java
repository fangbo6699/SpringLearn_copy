package com.fangbo.spring.lifestatus;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MypostProcess implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("bean对象"+o+"----"+"配置bean名字"+s+"postProcessBeforeInitialization");
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("bean对象"+o+"----"+"配置bean名字"+s+"postProcessAfterInitialization");
        Car car=new Car();
        car.setBrand("penci");
        car.setPrice("5000");
        return car;

    }
}
