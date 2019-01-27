package com.fangbo.spring.lifestatus;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        //1. 创建 Spring 的 IOC 容器
        ClassPathXmlApplicationContext ctx =new ClassPathXmlApplicationContext("file:src/beans_lifestatus.xml");
        Car car= (Car) ctx.getBean("person_lifestatus");
        System.out.println(car);
        ctx.close();
    }
}
