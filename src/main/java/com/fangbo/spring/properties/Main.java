package com.fangbo.spring.properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //1. 创建 Spring 的 IOC 容器
        ClassPathXmlApplicationContext cpx=new ClassPathXmlApplicationContext("file:src/beans_properties.xml");
        com.mchange.v2.c3p0.ComboPooledDataSource source= (ComboPooledDataSource) cpx.getBean("datasource");
        System.out.println(source.getConnection());
    }
}
