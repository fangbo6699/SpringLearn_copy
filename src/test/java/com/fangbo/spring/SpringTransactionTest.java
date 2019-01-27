package com.fangbo.spring;
import static org.junit.Assert.*;

import java.util.Arrays;

import com.fangbo.spring.tx.BookShopDao;
import com.fangbo.spring.tx.BookShopService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

    private ApplicationContext ctx = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService = null;
//    private Cashier cashier = null;

    {
        ctx =new ClassPathXmlApplicationContext("file:src/beans_tx.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
//        cashier = ctx.getBean(Cashier.class);
    }

    @Test
    public void testTransactionlPropagation(){
//        cashier.checkout("AA", Arrays.asList("1001", "1002"));
    }

    @Test
    public void testBookShopService(){
        bookShopService.purchase("fangbo", "1");
    }

    @Test
    public void testBookShopDaoUpdateUserAccount(){
        bookShopDao.updateUserAccount("fangbo", 200);
    }

    @Test
    public void testBookShopDaoUpdateBookStock(){
        bookShopDao.updateBookStock("2");
    }

    @Test
    public void testBookShopDaoFindPriceByIsbn() {
        System.out.println(bookShopDao.findBookPriceByIsbn("4"));
    }

}
