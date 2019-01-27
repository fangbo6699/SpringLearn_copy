package com.fangbo.spring.helloworld;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainList {
    public static void main(String[] args) {
        //1. 创建 Spring 的 IOC 容器
        ClassPathXmlApplicationContext cpx=new ClassPathXmlApplicationContext("file:src/beans_list.xml");
        PersonList personList01= (PersonList) cpx.getBean("perlist01");
        System.out.println(personList01);

       PersonMap personMap= (PersonMap) cpx.getBean("personmap01");
        System.out.println(personMap);

        DataSource ds= cpx.getBean(DataSource.class);
        System.out.println(ds);

        PersonList perlist02= (PersonList) cpx.getBean("personlist02");
        System.out.println(perlist02);
//<!--Spring 从 2.5 版本开始引入了一个新的 p 命名空间，可以通过 <bean> 元素属性的方式配置 Bean 的属性-->
        PersonList personlist03= (PersonList) cpx.getBean("personlist03");
        System.out.println(personlist03);
    }

}
