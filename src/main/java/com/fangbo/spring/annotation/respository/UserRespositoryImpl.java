package com.fangbo.spring.annotation.respository;

import org.springframework.stereotype.Repository;

@Repository("userRespository_test")
public class UserRespositoryImpl implements UserRespository{

    public void save() {
        System.out.println("UserRespositoryImpl.......");
    }
}
