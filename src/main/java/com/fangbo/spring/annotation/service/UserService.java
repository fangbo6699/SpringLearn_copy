package com.fangbo.spring.annotation.service;

import com.fangbo.spring.annotation.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRespository userRespository;
    @Autowired
    public void setUserRespository(@Qualifier("userJdbcRespository") UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public void UserService_test(){
        System.out.println("UserService ....UserService_test()");
        userRespository.save();
    }
}
