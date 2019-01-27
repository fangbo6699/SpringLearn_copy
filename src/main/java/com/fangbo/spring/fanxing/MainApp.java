package com.fangbo.spring.fanxing;
import com.fangbo.spring.factory.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        //1. 创建 Spring 的 IOC 容器
        ClassPathXmlApplicationContext ctx =new ClassPathXmlApplicationContext("file:src/beans_fanxing.xml");
        UserServer userServer= (UserServer) ctx.getBean("userServer");
        userServer.add();



    }
}
