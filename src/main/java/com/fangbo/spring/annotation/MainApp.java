package com.fangbo.spring.annotation;
import com.fangbo.spring.annotation.controller.UserController;
import com.fangbo.spring.annotation.respository.UserRespositoryImpl;
import com.fangbo.spring.annotation.service.UserService;
import com.fangbo.spring.factory.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        //1. 创建 Spring 的 IOC 容器
        ClassPathXmlApplicationContext ctx =new ClassPathXmlApplicationContext("file:src/beans_annotation.xml");
        BaseComponent baseComponent= (BaseComponent) ctx.getBean("baseComponent");
        System.out.println(baseComponent);

        UserController userController= (UserController) ctx.getBean("userController");
        System.out.println(userController);
        userController.exec();


        UserService userService= (UserService) ctx.getBean("userService");
        System.out.println(userService);

        UserRespositoryImpl userRespository_test= (UserRespositoryImpl) ctx.getBean("userRespository_test");
        System.out.println(userRespository_test);








    }
}
