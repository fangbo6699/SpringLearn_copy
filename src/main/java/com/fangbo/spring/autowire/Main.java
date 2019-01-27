package com.fangbo.spring.autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext cpx =new ClassPathXmlApplicationContext("file:src/beans_autowire.xml");
        Person person= (Person) cpx.getBean("person");
        System.out.println(person);


       Address address03= (Address) cpx.getBean("address03");
        System.out.println(address03);

        Address address04= (Address) cpx.getBean("address04");
        System.out.println(address04);

//        Address address05= (Address) cpx.getBean("address05");
//        System.out.println(address05);

        Address address06= (Address) cpx.getBean("address06");
        System.out.println(address06);

        Address address07= (Address) cpx.getBean("address07");
        System.out.println(address07);
        System.out.println("--------------------------------");
//        bean 的作用域：singleton；prototype；WEB 环境作用域
//        singleton是默认的作用域，使用关键词scope作为bean的内部属性配置
//        singleton是在创建ioc容器的时候据初始化了无参构造器，以后就是重复的使用，所谓的
//        单例模式，但是prototype是在调用getbean之后才创建的实例，调用一个创建一个新的

        Address address08= (Address) cpx.getBean("address08");
        System.out.println(address08);
        Address address09= (Address) cpx.getBean("address08");
        System.out.println(address09);
        System.out.println(address08==address09);

    }
}
