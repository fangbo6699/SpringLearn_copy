package com.fangbo.spring.tx;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTransactionTest {

    private ApplicationContext ctx = null;
    private BookShopDao bookShopDao = null;
    public BookShopService bookShopService;
//    private Cashier cashier = null;

    {
        ctx =new ClassPathXmlApplicationContext("file:src/beans_tx.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
//        cashier = ctx.getBean(Cashier.class);
    }

    public SpringTransactionTest() {
        bookShopService = null;
    }

    public static void main(String[] args) {
        new SpringTransactionTest().testBookShopService();
    }

    public void testTransactionlPropagation(){
//        cashier.checkout("AA", Arrays.asList("1001", "1002"));
    }


    public void testBookShopService(){
        bookShopService.purchase("fangbo", "1");
    }


    public void testBookShopDaoUpdateUserAccount(){
        bookShopDao.updateUserAccount("AA", 200);
    }

    public void testBookShopDaoUpdateBookStock(){
        bookShopDao.updateBookStock("1001");
    }


    public void testBookShopDaoFindPriceByIsbn() {
        System.out.println(bookShopDao.findBookPriceByIsbn("1"));
    }

}
