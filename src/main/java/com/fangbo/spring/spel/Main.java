package com.fangbo.spring.spel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("file:src/beans_spel.xml");
        Address address_spw01= (Address) cpx.getBean("address_spw01");
        System.out.println(address_spw01);
        Person person_spel01= (Person) cpx.getBean("person_spel01");
        System.out.println(person_spel01);

    }
}