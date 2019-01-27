package com.fangbo.spring.hibernate.test;


import java.sql.SQLException;
import java.util.Arrays;
import javax.sql.DataSource;

import com.fangbo.spring.tx.BookShopService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.atguigu.spring.hibernate.service.BookShopService;
//import com.atguigu.spring.hibernate.service.Cashier;

public class SpringHibernateTest {

    private ApplicationContext ctx = null;
    private BookShopService bookShopService = null;
//    private Cashier cashier = null;

    {
        ctx = new ClassPathXmlApplicationContext("file:src/bean_hibernate.xml");
//        bookShopService = ctx.getBean(BookShopService.class);
//        cashier = ctx.getBean(Cashier.class);
    }

    public static void main(String[] args) throws SQLException {
        new SpringHibernateTest().testDataSource();
    }

    public void testCashier(){
//        cashier.checkout("aa", Arrays.asList("1001","1002"));
    }


    public void testBookShopService(){
        bookShopService.purchase("aa", "1001");
    }


    public void testDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

}