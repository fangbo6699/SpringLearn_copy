package com.fangbo.spring.fanxing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BaseServer<T> {
    @Autowired()
    protected BaseRespository<T> baseRespository;
    public void add(){
        System.out.println("BaseServer add............");
        System.out.println(baseRespository);
    }

}
