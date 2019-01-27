package com.fangbo.spring.factory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        //1. 创建 Spring 的 IOC 容器
        ClassPathXmlApplicationContext ctx =new ClassPathXmlApplicationContext("file:src/beans_factory.xml");
        Car car= (Car) ctx.getBean("car11");
        System.out.println(car);

        Car car22= (Car) ctx.getBean("car22");
        System.out.println(car22);

        Car car33= (Car) ctx.getBean("carfangctorybean");
        System.out.println(car33);

    }
}
